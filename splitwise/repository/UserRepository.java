package splitwise.repository;

import splitwise.models.Group;
import splitwise.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    List<User> userList_;
    public UserRepository()
    {
        userList_ = new ArrayList<>();
    }

    public void addUser(User user)
    {
        userList_.add(user);
    }
    public Optional<User> findUserById(int id)
    {
        for(User user:userList_)
        {
            if(user.getId() == id)
                return Optional.of(user);
        }
        return Optional.empty();
    }
    public void addGroup(User user,Group group)
    {
        user.getGroupList().add(group);
    }
}
