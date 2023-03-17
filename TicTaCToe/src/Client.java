import Enums.BotType;
import Enums.GameStatus;
import Enums.PlayerType;
import Models.Bot;
import Models.Game;
import Models.Player;
import controller.GameController;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of Players");
        int countOfPlayers = Integer.valueOf(br.readLine());

        System.out.println("Do you want to keep one player as  bot ? y/n");

        char bot = String.valueOf(br.readLine()).charAt(0);

        List<Player> players = new ArrayList<>();
        if(bot=='y')
            countOfPlayers-=1;

        for(int i=0;i<countOfPlayers;i++)
        {
            System.out.println("Enter name of player");
            String name = String.valueOf(br.readLine());
            char symbol = String.valueOf(br.readLine()).charAt(0);
            players.add(new Player(name,symbol, PlayerType.HUMAN));
        }

        if(bot == 'y')
        {
            System.out.println("Enter bot details");
            System.out.println("Enter name of Bot");
            String name = String.valueOf(br.readLine());
            char symbol = String.valueOf(br.readLine()).charAt(0);
            players.add(new Bot(name,symbol, BotType.EASY));
        }

        GameController controller = new GameController();
        int dimension = players.size()+1;
        Game game = controller.creategame(dimension,players);

        while(game.getStatus() == GameStatus.IN_PROGRESS)
        {
            controller.displayBoard(game);

            game.makeNextMove();

        }

        if(game.getStatus() == GameStatus.END) {
            game.getBoard().displayBoard();
            System.out.println(game.getWinner().getName());
        }
        else
            System.out.println("Game Draw");

    }
}
