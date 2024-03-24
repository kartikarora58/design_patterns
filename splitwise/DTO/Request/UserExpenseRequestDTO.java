package splitwise.DTO.Request;

import splitwise.enums.ExpenseType;


public class UserExpenseRequestDTO {
    int userId;
    double amount;
    ExpenseType expenseType_;
    public UserExpenseRequestDTO(int userId, double amount, ExpenseType expenseType) {
        this.userId = userId;
        this.amount = amount;
        expenseType_ = expenseType;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseType getExpenseType() {
        return expenseType_;
    }

    public void setExpenseType(ExpenseType expenseType) {
        expenseType_ = expenseType;
    }

}
