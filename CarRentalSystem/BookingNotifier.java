package CarRentalSystem;

import java.util.List;

public class BookingNotifier {
    List<BookingSubscriber> bookingSubscriberList_;

    private static BookingNotifier bookingNotifier_;

    public static BookingNotifier getPublisher()
    {
        if(bookingNotifier_ == null)
        {
            bookingNotifier_ = new BookingNotifier();
        }
        return bookingNotifier_;
    }

    public void registerSubscriber(BookingSubscriber bookingSubscriber)
    {
        this.bookingSubscriberList_.add(bookingSubscriber);
    }

    public void removeSubscriber(BookingSubscriber bookingSubscriber)
    {
        this.bookingSubscriberList_.remove(bookingSubscriber);
    }

    public void notifySubscriber(Booking booking)
    {
        for(BookingSubscriber bookingSubscriber: bookingSubscriberList_)
        {
            bookingSubscriber.sendNotification(booking);
        }
    }

}
