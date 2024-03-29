package Models;

import Enums.CellState;

public class Cell {
    int row;
    int col;
    CellState state;
    Player player;

    public Cell(int row,int col)
    {
        this.row = row;
        this.col = col;
        state = CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player p) {
        this.player = p;
    }
}
