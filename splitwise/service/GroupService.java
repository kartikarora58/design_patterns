package splitwise.service;

import splitwise.DTO.Request.UserExpenseRequestDTO;
import splitwise.DTO.Response.TransactionResponse;
import splitwise.factory.SettleStrategyFactory;
import splitwise.models.Expense;
import splitwise.models.Group;
import splitwise.models.User;
import splitwise.models.UserExpense;
import splitwise.repository.ExpenseRepository;
import splitwise.repository.GroupRepository;
import splitwise.repository.UserExpenseRepository;
import splitwise.repository.UserRepository;
import splitwise.strategy.SettleStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupService {
    UserRepository userRepository_;
    GroupRepository groupRepository_;
    UserExpenseRepository userExpenseRepository_;
    ExpenseRepository expenseRepository_;
    int id = 0;
    int expenseId = 0;
    int userExpenseId = 0;

    public GroupService(
            UserRepository userRepository, GroupRepository groupRepository, UserExpenseRepository userExpenseRepository,
            ExpenseRepository expenseRepository) {
        userRepository_ = userRepository;
        groupRepository_ = groupRepository;
        userExpenseRepository_ = userExpenseRepository;
        expenseRepository_ = expenseRepository;
    }

    public int createGroup(int userId) {
        Optional<User> user = userRepository_.findUserById(userId);
        if (user.isEmpty()) {
            System.out.println("User is not present");
            return 0;
        }

        Group group = new Group(this.id++, user.get());
        groupRepository_.addGroup(group);
        userRepository_.addGroup(user.get(), group);
        System.out.println("group created successfully");
        return group.getId();



    }


    // here we are taking id only as paramter because when the request arrives from ui sending whole object is not
    // a good practice
    // we will send only ids
    public void addUserToGroup(int groupId, int userId) {
        Optional<Group> group = groupRepository_.findGroupById(groupId);
        Optional<User> user = userRepository_.findUserById(userId);
        groupRepository_.addUser(group.get(), user.get());
        userRepository_.addGroup(user.get(), group.get());
        System.out.println("user added to group");

    }

    public void addExpense(int groupId, double amount, List<UserExpenseRequestDTO> userExpenseRequestDTO) {
        Optional<Group> group = groupRepository_.findGroupById(groupId);
        Expense expense = new Expense(expenseId++, amount, group.get());
        for (UserExpenseRequestDTO userExpenseRequest : userExpenseRequestDTO) {
            Optional<User> user = userRepository_.findUserById(userExpenseRequest.getUserId());
            UserExpense userExpense = new UserExpense(userExpenseId++, user.get(), userExpenseRequest.getAmount(), userExpenseRequest.getExpenseType(), expense);
            expenseRepository_.addUserExpense(expense, userExpense);
            userExpenseRepository_.addUserExpense(userExpense);
        }
        expenseRepository_.addExpense(expense);
        System.out.println("Expense added successfully");
    }


    // for settling the transaction we require only group id
    // from group id we will find all the expenses and for each expense we will fetch user expense
    public List<TransactionResponse> settleTransaction(int groupId, String settleStrategy) {
        Optional<Group> group = groupRepository_.findGroupById(groupId);
        if (group.isEmpty()) {
            System.out.println("Group not found");
            return null;
        }
        else {
            List<UserExpense> userExpenseList = this.getUserExpenseList(group.get());
            SettleStrategy settleStrategy1 = SettleStrategyFactory.findSettleStrategy(settleStrategy);
            return settleStrategy1.settle(userExpenseList);
        }
    }

    public List<UserExpense> getUserExpenseList(Group group) {
        List<UserExpense> userExpenseList = new ArrayList<>();
        for (Expense expense : group.getExpenseList()) {
            userExpenseList.addAll(expense.getUserExpenseList());
        }
        return userExpenseList;
    }

}
