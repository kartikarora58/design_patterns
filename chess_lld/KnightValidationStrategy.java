package chess_lld;

public class KnightValidationStrategy implements MoveValidationStrategy{
    @Override
    public boolean isMoveValid(Board board, Pair source, Pair destination, PieceColor pieceColor) {
        int n = 8;
        int m = 8;
        if (destination.getRow() < 0 || destination.getRow() >= n && destination.getCol() < 0 || destination.getRow() >= m)
            return false;
        Piece piece = board.getCells().get(destination.getRow()).get(destination.getCol()).getPiece();
        if(piece!=null && piece.getPieceColor() == pieceColor)
            return false;
        int[][] moves = {{2,1},{1,2},{2,-1},{1,-2},{-2,1},{-1,2},{-2,-1},{-1,-2}};
        for(int[] move :moves)
        {
            int i = source.getRow() + move[0];
            int j = source.getCol() + move[1];
            if (i == destination.getRow() && j == destination.getCol()) {
                return true;
            }
        }
        return false;
    }
}
