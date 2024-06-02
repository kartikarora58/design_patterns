package kafka.consumer;

public interface ConsumerStrategy {
    public void consumeMessages(Consumer consumer);
}
