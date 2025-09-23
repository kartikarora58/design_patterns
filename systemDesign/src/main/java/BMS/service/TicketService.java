package BMS.service;

import BMS.enums.PaymentMode;
import BMS.enums.ShowSeatStatus;
import BMS.models.Show;
import BMS.models.ShowSeat;
import BMS.models.Ticket;
import BMS.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TicketService {

    Map<Integer, Ticket> ticketMap = new HashMap<>();
    ILockProvider lockProvider;

    public TicketService(ILockProvider lockProvider) {
        this.lockProvider = lockProvider;
    }

    public boolean bookTicket(Show show, User user, List<ShowSeat> showSeatList) throws InterruptedException {
        boolean isSuccess = lockProvider.acquireLock(showSeatList, user, show);

        if (!isSuccess)
           return false;


        int totalAmount = calculateTotalAmount(showSeatList);

        Ticket ticket = new Ticket();
        ticket.setId(UUID.randomUUID().toString());
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setAmount(totalAmount);
        ticket.setShowSeatsList(showSeatList);

        boolean paymentStatus = PaymentStrategy.getPaymentService(PaymentMode.DEBIT_CARD).doPayment(totalAmount);


        if(paymentStatus)
            showSeatList.stream().forEach(showSeat -> showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED));

        return true;


    }

    public int calculateTotalAmount(List<ShowSeat> showSeats) {
        return showSeats.stream()
                .mapToInt(ShowSeat::getPrice)
                .sum();
    }

}
