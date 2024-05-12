package CarRentalSystem;

import CarRentalSystem.enums.StoreStatus;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int id;
    String name;
    String address;
    StoreStatus storeStatus_;
    List<Vehicle> vehicleList_;
    List<Booking> bookingList_;

    public Store(int id,String name,String address,StoreStatus storeStatus)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.storeStatus_ = storeStatus;
        this.vehicleList_ = new ArrayList<>();
        this.bookingList_ = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StoreStatus getStoreStatus() {
        return storeStatus_;
    }

    public void setStoreStatus(StoreStatus storeStatus) {
        storeStatus_ = storeStatus;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList_;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        vehicleList_ = vehicleList;
    }

    public List<Booking> getBookingList() {
        return bookingList_;
    }

    public void setBookingList(List<Booking> bookingList) {
        bookingList_ = bookingList;
    }

}
