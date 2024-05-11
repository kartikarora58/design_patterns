package CarRentalSystem;

import CarRentalSystem.enums.BookingStatus;
import CarRentalSystem.enums.PaymentType;

public class Booking {
    int id;
    User user;
    Vehicle vehicle_;
    Slot slot_;
    Store store_;
    BookingStatus bookingStatus_;
    PaymentType paymentType_;

    public Booking(int id, User user, Vehicle vehicle, Slot slot, Store store, PaymentType paymentType)
    {
        this.id = id;
        this.user = user;
        this.vehicle_ = vehicle;
        this.slot_ = slot;
        this.store_ = store;
        this.paymentType_ = paymentType;
        this.bookingStatus_ = BookingStatus.IN_PROGRESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle_;
    }

    public void setVehicle(Vehicle vehicle) {
        vehicle_ = vehicle;
    }

    public Slot getSlot() {
        return slot_;
    }

    public void setSlot(Slot slot) {
        slot_ = slot;
    }

    public Store getStore() {
        return store_;
    }

    public void setStore(Store store) {
        store_ = store;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus_;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        bookingStatus_ = bookingStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType_;
    }

    public void setPaymentType(PaymentType paymentType) {
        paymentType_ = paymentType;
    }


}
