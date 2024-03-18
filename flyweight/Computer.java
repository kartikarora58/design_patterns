package flyweight;

public class Computer implements Robot{
    Sprite shape_;
    int height;
    String type;
    int x;
    int y;

    Computer(Sprite shape,int height,String type)
    {
        this.shape_ = shape;
        this.height = height;
        this.type = type;
    }
    @Override
    public void display(int i, int j) {

    }
}
