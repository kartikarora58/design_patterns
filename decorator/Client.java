package decorator;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new Capsicum(new Olives(new NormalBase()));
        System.out.println(pizza.getCost());
    }
}
