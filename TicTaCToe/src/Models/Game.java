package Models;

import Enums.CellState;
import Enums.GameStatus;
import Enums.PlayerType;
import Strategies.Win.WinningStrategy;
import Strategies.Win.WinningStrategyImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    int nextPlayerIndex;
    GameStatus status;
    Player winner;
    WinningStrategy winningStrategy;
    int dimension;
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }



    public void makeNextMove() throws IOException
    {
        Player activePlayer = this.players.get(nextPlayerIndex);

        System.out.println(activePlayer.getName()+"'s turn");

        Move move = activePlayer.performMove(this.board);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell currentCell = this.board.getCells().get(row).get(col);

        currentCell.setState(CellState.FILL);
        currentCell.setPlayer(activePlayer);



        this.moves.add(new Move(activePlayer,this.board.getCells().get(row).get(col)));

        if(winningStrategy.findWinner(this.board,activePlayer,currentCell))
        {
            this.winner = activePlayer;
            this.status = GameStatus.END;
        }

        if(this.moves.size() == this.dimension*this.dimension)
            this.status = GameStatus.DRAW;

        this.nextPlayerIndex = (this.nextPlayerIndex+1)%this.players.size();

    }

    private Game() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        int dimension;
        List<Player> players;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build()
        {
            Game game = new Game();
            game.board = new Board(dimension);
            game.players = players;
            game.moves = new ArrayList<>();
            game.nextPlayerIndex = 0;
            game.status = GameStatus.IN_PROGRESS;
            game.winningStrategy = new WinningStrategyImpl(dimension);
            return game;
        }
    }



}
