package decorator;

public class WheatBase implements Pizza{
    @Override
    public int getCost() {
        return 100;
    }
}
