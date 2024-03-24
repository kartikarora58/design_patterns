package splitwise.repository;

import splitwise.models.Expense;
import splitwise.models.Group;
import splitwise.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupRepository {
    List<Group> groupList_;
    public GroupRepository()
    {
        groupList_ = new ArrayList<>();
    }
    public void addGroup(Group group)
    {
        groupList_.add(group);
    }
    public void addExpense(Group group,Expense expense)
    {
        group.getExpenseList().add(expense);
    }
    public void addUser(Group group, User user)
    {
        group.getUserList().add(user);
    }
    public Optional<Group> findGroupById(int groupId)
    {
        for(Group group:groupList_)
        {
            if(group.getId()== groupId)
                return Optional.of(group);
        }
        return Optional.empty();
    }

}
