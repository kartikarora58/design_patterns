package models;

import enums.PaymentMode;
import enums.TransactionStatus;

public class Payment {
    PaymentMode paymentMode;
    int amount;
    TransactionStatus transactionStatus;
    String referenceId;
}
