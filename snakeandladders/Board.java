package snakeandladders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    List<List<Cell>> cells;

    Board() {
        cells = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                cells.get(i).add(new Cell(i, j));
            }
        }
    }

    public void initializeSnakes(int n)
    {
        Random random = new Random();
        for(int i=0;i<n;i++)
        {
            int first = random.nextInt(99);
            int second = random.nextInt(99);
            if(first>second)
            {
                cells.get(first/10).get(first%10).setJump(cells.get(second/10).get(second%10));
            }
            else{
                cells.get(second/10).get(second%10).setJump(cells.get(first/10).get(first%10));
            }
        }

    }
    public void initializeLadders(int m)
    {
        Random random = new Random();
        int first = random.nextInt(99);
        int second = random.nextInt(99);
        if(first>second)
        {
            cells.get(second/10).get(second%10).setJump(cells.get(first/10).get(first%10));
        }
        else{
            cells.get(first/10).get(first%10).setJump(cells.get(second/10).get(second%10));

        }
    }
    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }
}
