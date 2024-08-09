package chess_lld;

public class PlayerService {
    BoardService boardService_;

    PlayerService(BoardService boardService)
    {
        this.boardService_ = boardService;
    }

    public boolean performMove(Pair source, Pair destination, Board board, Player player)
    {
       boolean isMovePossible = boardService_.checkIfMoveIsValid(board,source,destination,player.getPieceColor());
       boolean isWinner = false;
       if(isMovePossible)
       {
           isWinner = boardService_.moveAndCheck(board,source,destination);
       }
       else{
           System.out.println("Invalid move");
       }
        if(isWinner)
            player.setWinner(true);

        return isMovePossible;
    }



}
