package Strategies.Bot;

import Models.Board;
import Models.Move;
import Models.Player;

public interface BotPlayStrategy {
    public Move performMove(Player p, Board board);
}
