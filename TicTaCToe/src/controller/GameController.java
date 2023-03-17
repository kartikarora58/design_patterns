package controller;

import Enums.GameStatus;
import Models.Game;
import Models.Player;

import java.io.IOException;
import java.util.List;

public class GameController {
    public Game creategame(int dimension, List<Player> players){
        return Game.builder().setDimension(dimension).setPlayers(players).build();
    }

    public void displayBoard(Game game) {
        game.getBoard().displayBoard();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getStatus();
    }

    public void executeNextMove(Game game) throws IOException {
        game.makeNextMove();
    }

    public Player getWinner(Game game)
    {
        return game.getWinner();
    }
}
