package splitwise.models;

import splitwise.enums.ExpenseType;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    // we can add discription as well
    // for eg dinner, bowling

    int id;
    double amount;

    // to which group this expense is associated
    Group group_;

    //this will indicate who paid the bill and who has to pay how much
    List<UserExpense> userExpenseList_;
    public Expense(int id, double amount, Group group) {
        this.id = id;
        this.amount = amount;
        group_ = group;
        userExpenseList_ = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Group getGroup() {
        return group_;
    }

    public void setGroup(Group group) {
        group_ = group;
    }

    public List<UserExpense> getUserExpenseList() {
        return userExpenseList_;
    }

    public void setUserExpenseList(List<UserExpense> userExpenseList) {
        userExpenseList_ = userExpenseList;
    }
}
