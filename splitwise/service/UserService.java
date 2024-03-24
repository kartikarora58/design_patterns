package splitwise.service;

import splitwise.models.User;
import splitwise.repository.UserExpenseRepository;
import splitwise.repository.UserRepository;

public class UserService {
    UserRepository userRepository_;
    int id = 0;

    public UserService(UserRepository userRepository) {
        userRepository_ = userRepository;
    }

    public int createUser(String name) {
        User user = new User(this.id++, name);
        userRepository_.addUser(user);
        return user.getId();
    }
}
