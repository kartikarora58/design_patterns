package Strategies.Win;

import Models.Board;
import Models.Cell;
import Models.Player;

public interface WinningStrategy {

    public boolean findWinner(Board board, Player activePlayer, Cell cell);
}
