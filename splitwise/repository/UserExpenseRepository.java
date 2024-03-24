package splitwise.repository;

import splitwise.models.Group;
import splitwise.models.UserExpense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserExpenseRepository {
    List<UserExpense> userExpenseList_;
    public UserExpenseRepository()
    {
        this.userExpenseList_ = new ArrayList<>();
    }

    public Optional<UserExpense> findGroupById(int userExpenseId)
    {
        for(UserExpense userExpense:userExpenseList_)
        {
            if(userExpense.getId()== userExpenseId)
                return Optional.of(userExpense);
        }
        return Optional.empty();
    }

    public void addUserExpense(UserExpense userExpense)
    {
        userExpenseList_.add(userExpense);
    }

}
