import java.time.LocalDateTime;

public class Payment {
    Ticket ticket_;
    int amount;
    LocalDateTime timeOfPayment;
    PaymentMethod paymentMethod_;

    public Payment(Ticket ticket, int amount, LocalDateTime timeOfPayment, PaymentMethod paymentMethod) {
        ticket_ = ticket;
        this.amount = amount;
        this.timeOfPayment = timeOfPayment;
        paymentMethod_ = paymentMethod;
    }

    public Ticket getTicket() {
        return ticket_;
    }

    public void setTicket(Ticket ticket) {
        ticket_ = ticket;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(LocalDateTime timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod_;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethod_ = paymentMethod;
    }


}
