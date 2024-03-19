package carRentalSystem;

import java.time.LocalDateTime;

public class Booking {
    int id;
    Store pickupStore;
    Store dropStore;
    User user;
    LocalDateTime pickupTime;
    LocalDateTime dropTime;
    Vehicle vehicle_;
    BookingStatus bookingStatus_;
    public Booking(
            int id, Store pickupStore, Store dropStore, User user, LocalDateTime pickupTime, LocalDateTime dropTime,
            Vehicle vehicle, BookingStatus bookingStatus) {
        this.id = id;
        this.pickupStore = pickupStore;
        this.dropStore = dropStore;
        this.user = user;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        vehicle_ = vehicle;
        bookingStatus_ = bookingStatus;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Store getPickupStore() {
        return pickupStore;
    }

    public void setPickupStore(Store pickupStore) {
        this.pickupStore = pickupStore;
    }

    public Store getDropStore() {
        return dropStore;
    }

    public void setDropStore(Store dropStore) {
        this.dropStore = dropStore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDateTime getDropTime() {
        return dropTime;
    }

    public void setDropTime(LocalDateTime dropTime) {
        this.dropTime = dropTime;
    }

    public Vehicle getVehicle() {
        return vehicle_;
    }

    public void setVehicle(Vehicle vehicle) {
        vehicle_ = vehicle;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus_;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        bookingStatus_ = bookingStatus;
    }


}
