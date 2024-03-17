package decorator;

public class Olives implements Ingredient{

    Pizza pizza_;
    Olives(Pizza pizza)
    {
        this.pizza_ = pizza;
    }
    @Override
    public int getCost() {
        return this.pizza_.getCost()+20;
    }
}
