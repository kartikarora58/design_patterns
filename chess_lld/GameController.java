package chess_lld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    Player player1;
    Player player2;
    BoardService boardService_;
    PlayerService playerService_;
    GameStatus gameStatus_;
    Player winner;

    GameController(Player player1,Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.boardService_ = new BoardService();
        this.playerService_ = new PlayerService(this.boardService_);
        this.gameStatus_ = GameStatus.IN_PROGRESS;
    }

    public Player startGame() throws IOException {
        Board board = boardService_.createBoard();
        int turn = 0;
        if(player2.getPieceColor() == PieceColor.WHITE)
            turn = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(gameStatus_==GameStatus.IN_PROGRESS)
        {
            boardService_.displayBoard(board);



            if(turn == 1)
            {
                System.out.println("player "+player2.getName()+"turn having color "+player2.getPieceColor());
                System.out.println("Enter source index row");
                int row = Integer.parseInt(br.readLine());
                System.out.println("Enter source index col");
                int col = Integer.parseInt(br.readLine());

                System.out.println("Enter destination index row");
                int desRow = Integer.parseInt(br.readLine());
                System.out.println("Enter destination index col");
                int desCol = Integer.parseInt(br.readLine());
                boolean wasMoveSuccess = playerService_.performMove(new Pair(row,col),new Pair(desRow,desCol),board,player2);
                if(wasMoveSuccess)
                {
                    turn = 0;
                    if(player2.isWinner) {
                        this.gameStatus_ = GameStatus.END;
                        this.winner = player2;
                    }
                }
            }
            else if(turn == 0)
            {
                System.out.println("player "+player1.getName()+"turn having color "+player1.getPieceColor());
                System.out.println("Enter source index row");
                int row = Integer.parseInt(br.readLine());
                System.out.println("Enter source index col");
                int col = Integer.parseInt(br.readLine());

                System.out.println("Enter destination index row");
                int desRow = Integer.parseInt(br.readLine());
                System.out.println("Enter destination index col");
                int desCol = Integer.parseInt(br.readLine());
                boolean wasMoveSuccess = playerService_.performMove(new Pair(row,col),new Pair(desRow,desCol),board,player1);
                if(wasMoveSuccess)
                {
                    turn = 1;
                    if(player1.isWinner) {
                        this.gameStatus_ = GameStatus.END;
                        this.winner = player1;
                    }
                }
            }

        }
        return winner;
    }

}
