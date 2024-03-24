package splitwise.DTO.Response;

public class TransactionResponse {
    String borrower;
    String lender;
    double amount;

    public TransactionResponse(String borrower, String lender, double amount) {
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }
    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
