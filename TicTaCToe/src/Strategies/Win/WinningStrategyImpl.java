package Strategies.Win;

import Models.Board;
import Models.Cell;
import Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStrategyImpl implements WinningStrategy{

    List<Map<Player,Integer>> rows= new ArrayList<>();
    List<Map<Player,Integer>> cols = new ArrayList<>();
    Map<Player,Integer> leftDiagonal = new HashMap<>();
    Map<Player,Integer> rightDiagonal = new HashMap<>();
    int dimension;

    public WinningStrategyImpl(int dimension)
    {
        this.dimension = dimension;
        for(int i=0;i<dimension;i++)
        {
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
        }
    }


    @Override
    public boolean findWinner(Board board, Player activePlayer, Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        Map<Player,Integer> rowMap = rows.get(row);
        Map<Player,Integer> colMap = cols.get(col);
        if(!rowMap.containsKey(activePlayer))
            rowMap.put(activePlayer,1);
        else
            rowMap.put(activePlayer,rowMap.get(activePlayer)+1);

        if(!colMap.containsKey(activePlayer))
            colMap.put(activePlayer,1);
        else
            colMap.put(activePlayer,colMap.get(activePlayer)+1);


        if(row == col)
        {
            if(!leftDiagonal.containsKey(activePlayer))
                leftDiagonal.put(activePlayer,1);
            else
                leftDiagonal.put(activePlayer,leftDiagonal.get(activePlayer)+1);
        }
        if(row+col == this.dimension-1)
        {
            if(!rightDiagonal.containsKey(activePlayer))
                rightDiagonal.put(activePlayer,1);
            else
                rightDiagonal.put(activePlayer,rightDiagonal.get(activePlayer)+1);
        }
        if(rows.get(row).get(activePlayer) == this.dimension)
            return true;
        if(cols.get(col).get(activePlayer) == this.dimension)
            return true;
        if(leftDiagonal.containsKey(activePlayer) && leftDiagonal.get(activePlayer) == this.dimension)
            return true;
        if(rightDiagonal.containsKey(activePlayer) && rightDiagonal.get(activePlayer) == this.dimension)
            return true;

        return false;



    }
}
