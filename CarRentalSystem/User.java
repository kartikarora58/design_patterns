package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String address;
    String licenseNumber;
    List<Booking> bookingList_;
    User(int id,String address,String licenseNumber)
    {
        this.id = id;
        this.address= address;
        this.licenseNumber = licenseNumber;
        this.bookingList_ = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public List<Booking> getBookingList() {
        return bookingList_;
    }

    public void setBookingList(List<Booking> bookingList) {
        bookingList_ = bookingList;
    }




}
