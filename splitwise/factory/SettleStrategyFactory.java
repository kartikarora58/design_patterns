package splitwise.factory;

import splitwise.strategy.ClockWiseSettleStrategy;
import splitwise.strategy.MinMaxSettleStrategy;
import splitwise.strategy.SettleStrategy;

public class SettleStrategyFactory {
    public static SettleStrategy findSettleStrategy(String strategy)
    {
        if(strategy.equals("min"))
            return new MinMaxSettleStrategy();
        return new ClockWiseSettleStrategy();
    }
}
