package carRentalSystem;

public class Bill {
    int id;
    Booking booking_;
    double amount;
    BillStatus billStatus_;

    public Bill(int id,Booking booking, double amount, BillStatus billStatus) {
        this.id = id;
        booking_ = booking;
        this.amount = amount;
        billStatus_ = billStatus;
    }

    public Booking getBooking() {
        return booking_;
    }

    public void setBooking(Booking booking) {
        booking_ = booking;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillStatus getBillStatus() {
        return billStatus_;
    }

    public void setBillStatus(BillStatus billStatus) {
        billStatus_ = billStatus;
    }

    public double calculateAmount(Booking booking)
    {
        return 100;
    }
    public void payBill(Bill bill)
    {
        Payment paymentService = new Payment();
        int res = paymentService.doPayment(bill.getAmount(),PaymentMethod.UPI);
        if(res == 200)
            bill.billStatus_ = BillStatus.PAID;
        else
            bill.billStatus_ = BillStatus.NOT_PAID;
    }




}
