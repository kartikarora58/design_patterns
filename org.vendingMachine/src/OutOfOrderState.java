public class OutOfOrderState implements State{

    private VendingMachine vendingMachine;

    OutOfOrderState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void addCoin() {
        System.out.println("Sorry machine is not working");
    }

    @Override
    public void pressDispenseButton() {
        System.out.println("Sorry machine is not working");
    }

    @Override
    public void refundAmount() {
        System.out.println("Sorry machine is not working");
    }

    @Override
    public void dispensing() {
        System.out.println("Sorry machine is not working");
    }
}
