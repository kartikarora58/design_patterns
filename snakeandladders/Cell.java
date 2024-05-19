package snakeandladders;

public class Cell {
    int row;
    int col;
    Cell jump;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
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

    public Cell getJump() {
        return jump;
    }

    public void setJump(Cell jump) {
        this.jump = jump;
    }
}
