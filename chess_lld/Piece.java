package chess_lld;

import java.util.UUID;

public class Piece {
    int id;
    PieceTypeEnum pieceTypeEnum_;
    PieceColor pieceColor_;

    Piece(PieceTypeEnum pieceTypeEnum, PieceColor pieceColor) {
        this.id = UUID.randomUUID().hashCode();
        this.pieceTypeEnum_ = pieceTypeEnum;
        this.pieceColor_ = pieceColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PieceTypeEnum getPieceTypeEnum() {
        return pieceTypeEnum_;
    }

    public void setPieceTypeEnum(PieceTypeEnum pieceTypeEnum) {
        pieceTypeEnum_ = pieceTypeEnum;
    }

    public PieceColor getPieceColor() {
        return pieceColor_;
    }

    public void setPieceColor(PieceColor pieceColor) {
        pieceColor_ = pieceColor;
    }


}
