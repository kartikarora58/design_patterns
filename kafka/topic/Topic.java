package kafka.topic;

import kafka.message.Message;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    int id;
    String name;
    List<Message> messageList_;

    public Topic(int id, String name) {
        this.id = id;
        this.name = name;
        messageList_= new ArrayList<>();
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

    public List<Message> getMessageList() {
        return messageList_;
    }

    public void setMessageList(List<Message> messageList) {
        messageList_ = messageList;
    }


}
