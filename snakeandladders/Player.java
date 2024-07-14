package snakeandladders;

import java.util.Random;

public class Player {
    String name;
    Cell cell_;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getCell() {
        return cell_;
    }

    public void setCell(Cell cell) {
        cell_ = cell;
    }


    public Cell performMove(Board board) {
        Random random = new Random();
        int number = random.nextInt(7);
        System.out.println(name + "got on dice is-" + number);
        int currentPosition = 0;

        if (this.cell_ != null) {
            currentPosition = this.cell_.getRow() * 10 + this.cell_.getCol();
        }
        // first find the current position and add new number
        currentPosition += number;

        int row = currentPosition / 10;
        int col = currentPosition % 10;
        System.out.println(name + " your current position is " + currentPosition);
        this.cell_ = board.getCells().get(row).get(col);
        // then at new position check if there is jump
        int newPosition = 0;
        if (this.cell_.getJump() != null) {
            newPosition = this.cell_.getJump().getRow() * 10 + this.cell_.getJump().getCol();
        }
        // find the jump number and
        // if it is greater than current position it means it's a ladder
        // otherwise you are bit by a snake


        if (newPosition != 0) {
            int newRow = newPosition / 10;
        }
        return null;
    }


}
