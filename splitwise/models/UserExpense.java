package splitwise.models;

import splitwise.enums.ExpenseType;


// this class indicate how much a user has paid
// to which expense
public class UserExpense {
    int id;
    User user;
    double amount;
    ExpenseType expenseType_;
    Expense expense_;

    public UserExpense(int id, User user, double amount, ExpenseType expenseType, Expense expense) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        expenseType_ = expenseType;
        expense_ = expense;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Expense getExpense() {
        return expense_;
    }

    public void setExpense(Expense expense) {
        expense_ = expense;
    }


}
