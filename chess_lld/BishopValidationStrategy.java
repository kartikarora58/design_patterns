package chess_lld;

public class BishopValidationStrategy implements MoveValidationStrategy{
    @Override
    public boolean isMoveValid(Board board, Pair source, Pair destination, PieceColor pieceColor) {
        int n = 8;
        int m = 8;
        if (destination.getRow() < 0 || destination.getRow() >= n && destination.getCol() < 0 || destination.getRow() >= m)
            return false;

        int sourceBottomDiagonal = n-source.getRow() + source.getCol();
        int sourceTopDiagonal = destination.getRow() + destination.getCol();

        int destBottomDiagonal =  n-source.getRow() + source.getCol();
        int desTopDiagonal = destination.getRow() + destination.getCol();

        if(sourceBottomDiagonal!=destBottomDiagonal && sourceTopDiagonal!=desTopDiagonal)
            return false;

        Piece piece = board.getCells().get(destination.getRow()).get(destination.getCol()).getPiece();
        if(piece!=null && piece.getPieceColor() == pieceColor)
            return false;
        int i = 1;
        int j = 1;
        if(destination.getRow()<source.getRow())
            i = -1;
        if(destination.getCol()<destination.getCol())
            j = -1;
        int startRow = source.getRow()+i;
        int startCol = source.getCol()+j;

        while(startRow!=destination.getRow() && startCol!=destination.getCol())
        {
            if(board.getCells().get(startRow).get(startCol).getPiece()!=null)
                return false;
            startRow+=i;
            startCol+=j;
        }
        return true;

    }
}
