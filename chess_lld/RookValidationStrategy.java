package chess_lld;

public class RookValidationStrategy implements MoveValidationStrategy{
    @Override
    public boolean isMoveValid(Board board, Pair source, Pair destination, PieceColor pieceColor) {
        int n = 8;
        int m = 8;
        if (destination.getRow() < 0 || destination.getRow() >= n && destination.getCol() < 0 || destination.getRow() >= m)
            return false;

        if(source.getRow()!=destination.getRow() && source.getCol()!=destination.getCol())
            return false;

        if(source.getRow() == destination.getRow())
        {
            int start = source.getCol()+1;
            int end = destination.getCol();

            if(destination.getCol()<source.getCol())
            {
                start = destination.getCol()+1;
                end = source.getCol();
            }
            int row = source.getRow();
            for(int i=start;i<end;i++)
            {
                if(board.getCells().get(row).get(i).getPiece()!=null)
                    return false;
            }
        }
        else if(source.getCol() == destination.getCol())
        {
            int start = source.getCol()+1;
            int end = destination.getCol();
            if(destination.getRow()<source.getRow())
            {
                start = destination.getRow()+1;
                end = source.getRow();
            }
            int col = source.getRow();
            for(int i=start;i<end;i++)
            {
                if(board.getCells().get(i).get(col).getPiece()!=null)
                    return false;
            }
        }
        Piece piece = board.getCells().get(destination.getRow()).get(destination.getCol()).getPiece();
        if(piece!=null && piece.getPieceColor() == pieceColor)
            return false;
        return true;
    }
}
