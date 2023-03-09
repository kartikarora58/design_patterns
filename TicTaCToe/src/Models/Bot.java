package Models;

import Enums.BotType;
import Enums.PlayerType;
import Factory.BotPlayingStrategyFactory;
import Strategies.Bot.BotPlayStrategy;

import java.io.IOException;

public class Bot extends Player{
    BotPlayStrategy strategy;
    BotType type;
    Bot(int id, String name, char symbol, BotType type)
    {
        super(id, name, symbol, PlayerType.BOT);
        this.type = type;
        strategy = BotPlayingStrategyFactory.getPlayStartegy(type);
    }

    @Override
    public Move performMove(Board board) {
        return strategy.performMove(this,board);
    }
}
