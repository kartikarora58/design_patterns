package chess_lld;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Player kartik = new Player("Kartik ",PieceColor.BLACK);
        Player ankit = new Player("Ankit ",PieceColor.WHITE);
        GameController gameController = new GameController(kartik,ankit);
        Player winner = gameController.startGame();
        System.out.println("winner is "+winner.getName());


    }
}
