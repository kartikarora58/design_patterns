package Models;

import Enums.CellState;

import java.util.*;

public class Board {
    List<List<Cell>> cells;

    Board(int n) {
        cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                cells.get(i).add(new Cell(i, j));
            }
        }

    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void displayBoard()
    {
        int n = cells.size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                Cell cell = cells.get(i).get(j);
                if(cell.getState() == CellState.BLOCKED)
                    System.out.print("|~|");
                else if(cell.getState() == CellState.FILL)
                    System.out.print("|"+cell.getPlayer().getSymbol()+"|");
                else
                    System.out.print("| |");
            }
            System.out.println();
        }
    }
}
