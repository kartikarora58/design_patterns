package BMS.controller;

import BMS.enums.ShowSeatStatus;
import BMS.models.*;
import BMS.service.PostgresLockProvider;
import BMS.service.ShowService;
import BMS.service.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BMSController {

    public static void main(String args[]) {
        TicketService ticketService = new TicketService(new PostgresLockProvider());
        ShowService service = new ShowService();
        List<Seat> seats = List.of(new Seat(1, "silver"), new Seat(2, "gold"), new Seat(3, "platinum"));
        Auditorium auditorium = new Auditorium(1, "audi1", seats);
        Theatre theatre = new Theatre(1, "waves", List.of(auditorium));

        Movie movie = new Movie(1, "interstellar");

        Show show = new Show();

        List<ShowSeat> showSeatList = auditorium.getSeats().stream().map(seat -> {
            if (seat.getSeatType().equals("silver"))
                return new ShowSeat(seat.getId(), show, seat, ShowSeatStatus.AVAILABLE, 200);
            else if (seat.getSeatType().equals("gold"))
                return new ShowSeat(seat.getId(), show, seat, ShowSeatStatus.AVAILABLE, 500);
            else
                return new ShowSeat(seat.getId(), show, seat, ShowSeatStatus.AVAILABLE, 800);
        }).toList();

        show.setId(1);
        show.setShowSeatList(showSeatList);
        show.setMovie(movie);
        show.setAuditorium(auditorium);
        show.setTheatre(theatre);

        User user = new User(1, "Kartik", "kartikarora58@gmail.com", "8594895894");

        ExecutorService executor = Executors.newFixedThreadPool(100);

        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 0; i < 70; i++) {
            Future<Boolean> future = executor.submit(() ->
                    ticketService.bookTicket(show, user, List.of(showSeatList.get(0)))
            );
            futures.add(future);
        }

// Wait for all tasks and print results
        for (Future<Boolean> f : futures) {
            try {
                if (f.get()) {
                    System.out.println("Seat booked");
                } else {
                    System.out.println("Seat unavailable");
                }
            } catch (Exception e) {
                System.out.println("Error booking seat");
            }
        }


        System.out.println("hi");

    }
}
