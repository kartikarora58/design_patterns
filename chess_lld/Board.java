package chess_lld;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> cells;
    Board()
    {
        cells = new ArrayList<>();
        for(int i=0;i<8;i++)
        {
            cells.add(new ArrayList<>());
        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                cells.get(i).add(new Cell(i,j));
            }
        }
    }
    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }
}
