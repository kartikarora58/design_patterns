package CarRentalSystem.controller;

import CarRentalSystem.Booking;
import CarRentalSystem.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList_;

    UserController()
    {
        this.userList_ = new ArrayList<>();
    }

    public User addUser(User user)
    {
        this.userList_.add(user);
        return user;
    }


    public void addBooking(User user, Booking booking)
    {
        user.getBookingList().add(booking);
    }
}
