package splitwise.repository;

import splitwise.models.Expense;
import splitwise.models.UserExpense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseRepository {
    List<Expense> expenseList_;
    public ExpenseRepository()
    {
        this.expenseList_ = new ArrayList<>();
    }

    public Optional<Expense> findExpenseById(int expenseId)
    {
        for(Expense expense:expenseList_)
        {
            if(expense.getId() == expenseId)
                return Optional.of(expense);
        }
        return Optional.empty();
    }
    public void addExpense(Expense expense)
    {
        expenseList_.add(expense);
    }

    public void addUserExpense(Expense expense,UserExpense userExpense)
    {
        expense.getUserExpenseList().add(userExpense);
    }

}
