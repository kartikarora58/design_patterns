package decorator;

public class Capsicum implements Ingredient{
    Pizza pizza_;
    Capsicum(Pizza pizza)
    {
        this.pizza_ = pizza;
    }
    @Override
    public int getCost() {
        return this.pizza_.getCost()+10;
    }
}
