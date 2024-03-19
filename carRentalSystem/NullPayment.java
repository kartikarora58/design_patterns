package carRentalSystem;

public class NullPayment implements PaymentStrategy{
    @Override
    public int makePayment(double amount) {
        System.out.println("Invalid payment method");
        return 400;
    }
}
