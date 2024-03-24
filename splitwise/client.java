package splitwise;

import splitwise.DTO.Request.AddExpenseRequestDTO;
import splitwise.models.Group;
import splitwise.models.User;
import splitwise.models.UserExpense;
import splitwise.repository.ExpenseRepository;
import splitwise.repository.GroupRepository;
import splitwise.repository.UserExpenseRepository;
import splitwise.repository.UserRepository;
import splitwise.service.GroupService;
import splitwise.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class client {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        GroupRepository groupRepository = new GroupRepository();
        UserExpenseRepository userExpenseRepository = new UserExpenseRepository();
        ExpenseRepository expenseRepository = new ExpenseRepository();
        UserService userService = new UserService(userRepository);

        GroupService groupService = new GroupService(userRepository, groupRepository, userExpenseRepository, expenseRepository);
        int userId = userService.createUser("Kartik");
        int groupId = groupService.createGroup(userId);

//        creating users in the group
        List<String> groupMemberNames = new ArrayList<>(Arrays.asList("Karan", "Arash", "Anjali"));
        List<Integer> userIdList = new ArrayList<>();
        for (String memberName : groupMemberNames) {
            int groupMemberId = userService.createUser(memberName);
            userIdList.add(groupMemberId);
            groupService.addUserToGroup(groupId, groupMemberId);
        }

    }


}
