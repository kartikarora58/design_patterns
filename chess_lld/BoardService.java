package chess_lld;

public class BoardService {

    public Board createBoard() {

        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            board.getCells().get(1).get(i).setPiece(new Piece(PieceTypeEnum.PAWN, PieceColor.WHITE));
            board.getCells().get(6).get(i).setPiece(new Piece(PieceTypeEnum.PAWN, PieceColor.BLACK));
        }
        int rook[][] = {{0, 0, 1}, {0, 7, 1}, {7, 0, 0}, {7, 7, 0}};
        int knight[][] = {{0, 1, 1}, {0, 6, 1}, {7, 1, 0}, {7, 6, 0}};
        int bishop[][] = {{0, 2, 1}, {0, 5, 1}, {7, 2, 0}, {7, 5, 0}};
        int king[][] = {{0, 3, 1}, {7, 4, 0}};
        int queen[][] = {{0, 4, 1}, {7, 3, 0}};

        for (int[] r : rook) {
            int row = r[0];
            int col = r[1];
            int color = r[2];
            PieceColor pieceColor = PieceColor.WHITE;
            if (color == 0)
                pieceColor = PieceColor.BLACK;
            board.getCells().get(row).get(col).setPiece(new Piece(PieceTypeEnum.ROOK, pieceColor));
        }
        for (int[] r : knight) {
            int row = r[0];
            int col = r[1];
            int color = r[2];
            PieceColor pieceColor = PieceColor.WHITE;
            if (color == 0)
                pieceColor = PieceColor.BLACK;
            board.getCells().get(row).get(col).setPiece(new Piece(PieceTypeEnum.KNIGHT, pieceColor));
        }
        for (int[] r : bishop) {
            int row = r[0];
            int col = r[1];
            int color = r[2];
            PieceColor pieceColor = PieceColor.WHITE;
            if (color == 0)
                pieceColor = PieceColor.BLACK;
            board.getCells().get(row).get(col).setPiece(new Piece(PieceTypeEnum.BISHOP, pieceColor));
        }
        for (int[] r : king) {
            int row = r[0];
            int col = r[1];
            int color = r[2];
            PieceColor pieceColor = PieceColor.WHITE;
            if (color == 0)
                pieceColor = PieceColor.BLACK;
            board.getCells().get(row).get(col).setPiece(new Piece(PieceTypeEnum.KING, pieceColor));
        }
        for (int[] r : queen) {
            int row = r[0];
            int col = r[1];
            int color = r[2];
            PieceColor pieceColor = PieceColor.WHITE;
            if (color == 0)
                pieceColor = PieceColor.BLACK;
            board.getCells().get(row).get(col).setPiece(new Piece(PieceTypeEnum.QUEEN, pieceColor));
        }
        return board;

    }

    public boolean checkIfMoveIsValid(Board board, Pair source, Pair destination, PieceColor playerPieceColor) {
        int n = 8;
        int m = 8;
        if (source.getRow() < 0 || source.getRow() >= n && source.getCol() < 0 && source.getCol() >= m)
            return false;
        Piece piece = board.getCells().get(source.getRow()).get(source.getCol()).getPiece();
        if (piece == null || piece.getPieceColor() != playerPieceColor)
            return false;
        MoveValidationStrategy moveValidationStrategy = MoveValidationFactory.findValidationStrategy(piece.getPieceTypeEnum());
        if (moveValidationStrategy == null)
            return false;
        return moveValidationStrategy.isMoveValid(board, source, destination, playerPieceColor);
    }

    public boolean moveAndCheck(Board board, Pair source, Pair destination) {

        Piece sourcePiece = board.getCells().get(source.getRow()).get(source.getCol()).getPiece();
        Piece destinationPiece = board.getCells().get(destination.getRow()).get(destination.getCol()).getPiece();
        if (destinationPiece != null) {
            System.out.println("Killing " + destinationPiece.getPieceTypeEnum() + " of color " + destinationPiece.getPieceColor());
        }
        board.getCells().get(destination.getRow()).get(destination.getCol()).setPiece(sourcePiece);
        board.getCells().get(source.getRow()).get(source.getCol()).setPiece(null);
        return destinationPiece != null && destinationPiece.getPieceTypeEnum() == PieceTypeEnum.KING;
    }

    public void displayBoard(Board board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getCells().get(i).get(j).getPiece();
                if (piece != null) {
                    String s= piece.getPieceTypeEnum() + "(" + piece.getPieceColor() + ")";
                    int reqChars = 15-s.length();
                    for(int count=0;count<reqChars;count++)
                    {
                        s+=' ';
                    }
                    System.out.print("|"+s+"|");
                } else {
                    System.out.print("|               |");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("|(" + i + "," + j + ")|");
            }
            System.out.println();
        }
    }
}
