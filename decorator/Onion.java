package decorator;

public class Onion implements Ingredient{
    Pizza pizza_;
    Onion(Pizza pizza)
    {
        this.pizza_ = pizza;
    }
    @Override
    public int getCost() {
        return this.pizza_.getCost()+15;
    }
}
