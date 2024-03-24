package splitwise.strategy;

import splitwise.DTO.Response.TransactionResponse;
import splitwise.enums.ExpenseType;
import splitwise.models.User;
import splitwise.models.UserExpense;

import java.util.*;

public class MinMaxSettleStrategy implements SettleStrategy{

    class Pair{
        String userName;
        double amount;

        Pair(String userName,double amount)
        {
            this.userName = userName;
            this.amount = amount;
        }

    }

    // we need only user expense here

    // -400 means has to pay
    // 300 means has already paid
    @Override
    public List<TransactionResponse> settle(List<UserExpense> userExpenseList) {

        Map<User,Double> map = new HashMap<>();
        for(UserExpense userExpense:userExpenseList)
        {
           User user = userExpense.getUser();
           if(!map.containsKey(user))
               map.put(user, (double) 0);
           // If a person has paid we will add that amount to map
           if(userExpense.getExpenseType() == ExpenseType.PAID)
               map.put(user,map.get(user)+ userExpense.getAmount());
           // for had to pay we will subtract and if that person has not paid we will subtract from 0
           else if(userExpense.getExpenseType() == ExpenseType.HAD_TO_PAY)
               map.put(user,map.get(user)- userExpense.getAmount());
        }


        // separate borrower and lender
        // borrower who with negative sign
        // lender with positive sign
        PriorityQueue<Pair> borrower = new PriorityQueue<>();
        PriorityQueue<Pair> lender = new PriorityQueue<>(Collections.reverseOrder());

        for(User user:map.keySet())
        {
            if(map.get(user)<0)
                borrower.add(new Pair(user.getName(),map.get(user)));
            else
                lender.add(new Pair(user.getName(),map.get(user)));
        }
        List<TransactionResponse> transactionResponseList = new ArrayList<>();
        while(!borrower.isEmpty() && !lender.isEmpty())
        {
            // borrower will pay to lender
            Pair borrow = borrower.remove();
            Pair lend = lender.remove();
            double amount = borrow.amount + lend.amount;
            // there could be a possibility that lender was expecting 300
            // but he got 500
            // extra 200 bucks belongs to some other person
            // so this lender has to pay extra (-200)
            // it means we will add this amount again in borrower.
            // if lender got only 100 still he need 200
            // it means he is still a lender
            // we will add it to lender
            // we will continue this until
            // both the queues are empty
            // every transaction we can maintain a transaction object
            // who is borrower and who is lender and how much will be the transaction amount
            transactionResponseList.add(new TransactionResponse(borrow.userName,lend.userName,amount));
            if(amount<0)
                borrower.add(new Pair(lend.userName,amount));
            else
                lender.add(new Pair(lend.userName,amount));

        }
        return transactionResponseList;
    }
}
