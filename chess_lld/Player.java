package chess_lld;

import java.util.UUID;

public class Player {
    int id;
    String name;
    PieceColor pieceColor_;
    boolean isWinner;

    Player(String name,PieceColor pieceColor)
    {
        this.id = UUID.randomUUID().hashCode();
        this.name = name;
        this.pieceColor_ = pieceColor;
        this.isWinner = false;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceColor getPieceColor() {
        return pieceColor_;
    }

    public void setPieceColor(PieceColor pieceColor) {
        pieceColor_ = pieceColor;
    }
    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
