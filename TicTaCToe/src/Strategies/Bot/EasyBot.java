package Strategies.Bot;

import Enums.CellState;
import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player;

import java.util.List;

public class EasyBot implements BotPlayStrategy{

    @Override
    public Move performMove(Player p, Board board) {
        List<List<Cell>> cells = board.getCells();
        int n = cells.size();

        Move move=null;
        for (int row = 0; row < n; row++)
        {
            for(int col = 0;col<n;col++)
            {
                Cell cell = cells.get(row).get(col);
                if(cell.getState() == CellState.EMPTY)
                {
                    move = new Move(p,new Cell(row,col));
                    return move;
                }
            }
        }
        return move;
    }
}
