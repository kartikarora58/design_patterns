package Models;

import Enums.CellState;
import Enums.PlayerType;
import Exceptions.InvalidCellException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    String name;
    char symbol;
    PlayerType type;

    public Player(String name, char symbol, PlayerType type)
    {

        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move performMove(Board board) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.valueOf(br.readLine());
        int col = Integer.valueOf(br.readLine());

        if(board.getCells().get(row).get(col).getState() != CellState.EMPTY)
                throw new InvalidCellException();
        return new Move(this,new Cell(row,col));
    }
}
