package CarRentalSystem;

public class UserSubscriber implements BookingSubscriber{
    @Override
    public void sendNotification(Booking booking) {
        System.out.println("Your booking is "+booking.getBookingStatus());
    }
}
