package splitwise.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;

    // this indicates in which group user is present
    List<Group> groupList_;

    // not taking group in constructor because a user cannot be associated with a group
    public User(int id, String name) {
        this.id = id;
        this.name = name;
        groupList_ = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroupList() {
        return groupList_;
    }

    public void setGroupList(List<Group> groupList) {
        groupList_ = groupList;
    }
}
