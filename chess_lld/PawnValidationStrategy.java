package chess_lld;

public class PawnValidationStrategy implements MoveValidationStrategy{
    @Override
    public boolean isMoveValid(Board board, Pair source, Pair destination, PieceColor pieceColor) {
        int n = 8;
        int m = 8;
        if (destination.getRow() < 0 || destination.getRow() >= n || destination.getCol() < 0 || destination.getCol() >= m)
            return false;

        Piece piece = board.getCells().get(destination.getRow()).get(destination.getCol()).getPiece();
        if(piece!=null && piece.getPieceColor() == pieceColor)
            return false;

        if(pieceColor == PieceColor.WHITE && source.getRow()+1 == destination.getRow())
        {
            int sourceColumn = source.getCol();
            if(source.getCol()!=destination.getCol() && sourceColumn+1!=destination.getCol() && sourceColumn-1!=destination.getCol())
                return false;
        }
        else if(pieceColor == PieceColor.BLACK && source.getRow()-1 == destination.getRow())
        {
            int sourceColumn = source.getCol();
            if(source.getCol()!=destination.getCol() && sourceColumn+1!=destination.getCol() && sourceColumn-1!=destination.getCol())
                return false;
        }
        else{
            return false;
        }
        return true;
    }
}
