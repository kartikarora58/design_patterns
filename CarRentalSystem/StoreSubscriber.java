package CarRentalSystem;

public class StoreSubscriber implements BookingSubscriber{
    @Override
    public void sendNotification(Booking booking) {
        System.out.println("Hey store there is a booking for your store");
    }
}
