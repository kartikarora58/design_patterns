package splitwise.strategy;

import splitwise.DTO.Response.TransactionResponse;
import splitwise.models.UserExpense;

import java.util.List;

public class ClockWiseSettleStrategy implements SettleStrategy{
    @Override
    public List<TransactionResponse> settle(List<UserExpense> userExpenseList) {
        return null;
    }
}
