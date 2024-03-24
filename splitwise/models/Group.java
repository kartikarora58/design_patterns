package splitwise.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    int id;
    User createdBy;

    // list of expenses
    List<Expense> expenseList_;

    // users associated with this group
    List<User> userList_;

    // we are not adding users and expense in constructor since there can be empty group
    // and we can add expense and user to it later on
    public Group(int id, User createdBy) {
        this.id = id;
        this.createdBy = createdBy;
        expenseList_ = new ArrayList<>();
        userList_ = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Expense> getExpenseList() {
        return expenseList_;
    }

    public void setExpenseList(List<Expense> expenseList) {
        expenseList_ = expenseList;
    }

    public List<User> getUserList() {
        return userList_;
    }

    public void setUserList(List<User> userList) {
        userList_ = userList;
    }
}
