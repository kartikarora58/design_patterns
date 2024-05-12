package CarRentalSystem;

import CarRentalSystem.enums.PaymentStatus;
import CarRentalSystem.enums.PaymentType;

public class Payment {
    int id;
    Booking booking_;
    int amount;
    PaymentStatus paymentStatus_;
    PaymentType paymentType_;

    public Payment(int id, Booking booking, int amount, PaymentType paymentType)
    {
        this.id = id;
        this.booking_ = booking;
        this.amount = amount;
        this.paymentType_ = paymentType;
        this.paymentStatus_ = PaymentStatus.FAIL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking_;
    }

    public void setBooking(Booking booking) {
        booking_ = booking;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus_;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        paymentStatus_ = paymentStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType_;
    }

    public void setPaymentType(PaymentType paymentType) {
        paymentType_ = paymentType;
    }



}
