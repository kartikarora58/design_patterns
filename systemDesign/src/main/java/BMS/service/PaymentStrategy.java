package BMS.service;

import BMS.enums.PaymentMode;

public class PaymentStrategy {

    public static IPaymentService getPaymentService(PaymentMode paymentMode) {
        switch (paymentMode) {
            case DEBIT_CARD:
                return new CardPaymentService();
            default:
                return null;
        }
    }


}
