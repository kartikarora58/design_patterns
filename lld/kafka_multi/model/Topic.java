package lld.kafka_multi.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    public int id;
    public String name;
    public List<Message> messages;


    public Topic(int id,String name)
    {
        this.id = id;
        this.name = name;
        this.messages = new ArrayList<>();
    }
}
