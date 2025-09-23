package BMS.models;

import BMS.enums.PaymentMode;
import BMS.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    int id;
    Ticket ticket;
    PaymentStatus paymentStatus;
    PaymentMode paymentMode;
}
