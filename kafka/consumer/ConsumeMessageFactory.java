package kafka.consumer;

public class ConsumeMessageFactory {

    public static ConsumerStrategy findConsumerStrategy(ConsumerEnum consumerEnum)
    {
        if(consumerEnum == ConsumerEnum.ROUND_ROBIN)
            return new RoundRobinConsumer();

        return null;
    }
}
