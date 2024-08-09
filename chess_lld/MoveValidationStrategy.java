package chess_lld;

public interface MoveValidationStrategy {

    public boolean isMoveValid(Board board,Pair source,Pair destination,PieceColor pieceColor);
}
