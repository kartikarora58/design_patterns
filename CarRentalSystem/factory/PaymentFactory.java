package CarRentalSystem.factory;

import CarRentalSystem.enums.PaymentType;
import CarRentalSystem.strategy.PaymentStrategy;
import CarRentalSystem.strategy.impl.CardPayment;
import CarRentalSystem.strategy.impl.NetBanking;
import CarRentalSystem.strategy.impl.NullPayment;
import CarRentalSystem.strategy.impl.UPIPayment;

public class PaymentFactory {

    public static PaymentStrategy findPaymentGateway(PaymentType paymentType)
    {
        if(paymentType == PaymentType.CARD)
            return new CardPayment();
        else if(paymentType == PaymentType.UPI)
            return new UPIPayment();
        else if(paymentType == PaymentType.NET_BANKING)
            return new NetBanking();
        return new NullPayment();
    }

}
