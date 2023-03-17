package Models;

import Enums.CellState;

public class Move {

    Player p;
    Cell cell;

    public Move(Player p,Cell cell)
    {
        this.p = p;
        this.cell = cell;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
