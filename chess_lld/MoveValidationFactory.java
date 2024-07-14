package chess_lld;

public class MoveValidationFactory {

    public static MoveValidationStrategy findValidationStrategy(PieceTypeEnum pieceTypeEnum)
    {
        if(pieceTypeEnum == PieceTypeEnum.KING)
            return new KingValidationstrategy();
        else if(pieceTypeEnum == PieceTypeEnum.BISHOP)
            return new BishopValidationStrategy();
        else if(pieceTypeEnum == PieceTypeEnum.KNIGHT)
            return new KnightValidationStrategy();
        else if(pieceTypeEnum == PieceTypeEnum.PAWN)
            return new PawnValidationStrategy();
        else if(pieceTypeEnum == PieceTypeEnum.QUEEN)
            return new QueenValidationStrategy();
        else if(pieceTypeEnum == PieceTypeEnum.ROOK)
            return new RookValidationStrategy();
        return null;

    }
}
