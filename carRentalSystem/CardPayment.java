package carRentalSystem;

public class CardPayment implements PaymentStrategy{
    @Override
    public int makePayment(double amount) {
        return 200;
    }
}
