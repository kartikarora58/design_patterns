package carRentalSystem;

import java.util.List;

public class Store {
    int id;
    String name;
    Location location_;
    List<Booking> bookings;
    VehicleInventory vehicleInventory_;
    StoreStatus storeStatus_;

    Store(int id,String name,StoreStatus storeStatus,Location location)
    {
        this.id = id;
        this.name = name;
        this.storeStatus_ = storeStatus;
        this.location_ = location;
    }

    public void addBooking(Booking booking)
    {
        bookings.add(booking);
    }



}
