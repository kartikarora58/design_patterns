package flyweight;

public class HumanRobot implements Robot{
    Sprite shape_;
    int height;
    String type;
    int x;
    int y;

    HumanRobot(Sprite shape,int height,String type)
    {
        this.shape_ = shape;
        this.height = height;
        this.type = type;
    }
    @Override
    public void display(int i, int j) {
        this.x = i;
        this.y = j;
        System.out.println("Position is-"+i+"-j");
    }
}
