package kafka.publisher;

import kafka.topic.Topic;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    int id;
    String name;
    List<Topic> topicList_;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
        topicList_ = new ArrayList<>();
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

    public List<Topic> getTopicList() {
        return topicList_;
    }

    public void setTopicList(List<Topic> topicList) {
        topicList_ = topicList;
    }

}
