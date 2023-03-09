package Models;

import Enums.GameStatus;
import Enums.PlayerType;

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

    private Game() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Board board;
        List<Player> players;
        List<Move> moves;
        int nextPlayerIndex;
        GameStatus status;
        Player winner;

        public Board getBoard() {
            return board;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<Move> getMoves() {
            return moves;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public int getNextPlayerIndex() {
            return nextPlayerIndex;
        }

        public Builder setNextPlayerIndex(int nextPlayerIndex) {
            this.nextPlayerIndex = nextPlayerIndex;
            return this;
        }

        public GameStatus getStatus() {
            return status;
        }

        public Builder setStatus(GameStatus status) {
            this.status = status;
            return this;
        }

        public Player getWinner() {
            return winner;
        }

        public Builder setWinner(Player winner) {
            this.winner = winner;
            return this;
        }

        public Game build() {
//            try{
//
//            }
//            catch(Exception e)
//            {
//
//            }
            Game ob = new Game();
            ob.board = new Board(3);
            ob.players = Arrays.asList(new Player(1, "kartik", 'O', PlayerType.HUMAN), new Player(2, "enemy", 'X', PlayerType.BOT));
            ob.moves = new ArrayList<>();
            ob.status = GameStatus.IN_PROGRESS;

            return ob;
        }
    }


}
