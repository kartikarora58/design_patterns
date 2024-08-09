package chess_lld;

public class Cell {
    int row;
    int col;
    Piece piece_;

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

    public Piece getPiece() {
        return piece_;
    }

    public void setPiece(Piece piece) {
        piece_ = piece;
    }

}
