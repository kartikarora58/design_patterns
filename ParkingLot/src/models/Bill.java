package models;

import enums.TransactionStatus;

import java.util.Date;
import java.util.List;

public class Bill {
    Ticket ticket;
    Operator operator;
    Date exitTime;
    Gate exitGate;
    List<Payment> payments;
    TransactionStatus status;
}
