package carRentalSystem;

public class Payment {
    int id;
    Bill bill;
    PaymentMethod paymentMethod_;
    PaymentStatus paymentStatus_;
    public Payment(int id, Bill bill, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.id = id;
        this.bill = bill;
        paymentMethod_ = paymentMethod;
        paymentStatus_ = paymentStatus;
    }

    public Payment()
    {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod_;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethod_ = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus_;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        paymentStatus_ = paymentStatus;
    }

    public int doPayment(double amount,PaymentMethod paymentMethod)
    {
        PaymentStrategy paymentStrategy = PaymentFactory.getPaymentGateway(paymentMethod);
        return paymentStrategy.makePayment(amount);
    }


}
