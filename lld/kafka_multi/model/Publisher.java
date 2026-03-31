package lld.kafka_multi.model;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    int id;
    String name;
    public List<Topic> topics;

    public Publisher(int id,String name)
    {
        this.id = id;
        this.name = name;
        this.topics = new ArrayList<>();
    }
}