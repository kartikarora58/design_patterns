package carRentalSystem;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public int makePayment(double amount) {
        return 200;
    }
}
