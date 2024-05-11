package CarRentalSystem.controller;

import CarRentalSystem.*;
import CarRentalSystem.enums.BookingStatus;
import CarRentalSystem.enums.PaymentStatus;
import CarRentalSystem.enums.PaymentType;
import CarRentalSystem.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class BookingController {

    List<Booking> bookingList_;
    PaymentController paymentController_;
    BookingNotifier bookingNotifier_;

    BookingController() {
        bookingList_ = new ArrayList<>();
        paymentController_ = new PaymentController();
        bookingNotifier_ = BookingNotifier.getPublisher();
    }

    public Booking createBooking(Booking booking) {
        bookingList_.add(booking);
        return booking;
    }

    public Booking bookVehicle(User user, Vehicle vehicle, Store store, Slot slot, PaymentType paymentType) {
        int index = bookingList_.size();
        Booking booking = new Booking(index, user, vehicle, slot, store, paymentType);
        // calculate total hours using slot and hourly rate
        int amount = 5000;
        boolean res = paymentController_.doPayment(amount, booking, paymentType);
        if (res)
            booking.setBookingStatus(BookingStatus.CONFIRMED);
        else
            booking.setBookingStatus(BookingStatus.FAILED);
        booking = this.createBooking(booking);
        bookingNotifier_.notifySubscriber(booking);
        return booking;


    }

}
