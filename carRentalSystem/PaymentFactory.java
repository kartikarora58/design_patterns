package carRentalSystem;

public class PaymentFactory {

    public static PaymentStrategy getPaymentGateway(PaymentMethod paymentMethod)
    {
        if(paymentMethod == PaymentMethod.CARD)
            return new CardPayment();
        else if(paymentMethod == PaymentMethod.UPI)
            return new UpiPaymentStrategy();
        return new NullPayment();
    }
}
