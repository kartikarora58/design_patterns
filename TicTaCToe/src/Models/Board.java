package Models;

import java.util.*;

public class Board {
    List<List<Cell>> cells;

    Board(int n) {
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
}
