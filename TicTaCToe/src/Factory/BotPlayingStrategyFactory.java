package Factory;

import Enums.BotType;
import Models.Bot;
import Strategies.Bot.BotPlayStrategy;
import Strategies.Bot.EasyBot;
import Strategies.Bot.HardBot;
import Strategies.Bot.MediumBot;

import java.util.HashMap;

public class BotPlayingStrategyFactory {

    public static BotPlayStrategy getPlayStartegy(BotType type)
    {
        if(type == BotType.EASY)
            return new EasyBot();
        else if(type == BotType.MEDIUM)
            return new MediumBot();
        return new HardBot();
    }
}
