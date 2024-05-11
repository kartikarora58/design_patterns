package CarRentalSystem.controller;

import CarRentalSystem.Booking;
import CarRentalSystem.Payment;
import CarRentalSystem.enums.PaymentStatus;
import CarRentalSystem.enums.PaymentType;
import CarRentalSystem.factory.PaymentFactory;
import CarRentalSystem.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {

   List<Payment> paymentList_;
   PaymentController()
   {
       paymentList_ = new ArrayList<>();
   }

   public Payment createPayment(Payment payment)
   {
       paymentList_.add(payment);
       return payment;
   }

   public boolean doPayment(int amount , Booking booking, PaymentType paymentType)
   {
       Payment payment = new Payment(paymentList_.size(), booking,amount,paymentType);
       PaymentStrategy paymentStrategy = PaymentFactory.findPaymentGateway(paymentType);
       boolean res =  paymentStrategy.doPayment(amount);
       if(res)
           payment.setPaymentStatus(PaymentStatus.SUCCESS);
       Payment payment1 = this.createPayment(payment);
       return res;
   }


}
