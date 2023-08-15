public class IdleState implements State{

    private VendingMachine vendingMachine;

    IdleState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void addCoin() {
        System.out.println("Coin added!, Press dispense button");
        this.vendingMachine.setCurrentState(this.vendingMachine.getHasCoinState());
    }

    @Override
    public void pressDispenseButton() {
        System.out.println("insert a coint to get a drink");
    }

    @Override
    public void refundAmount() {
        System.out.println("oops! there isn't a coin");

    }

    @Override
    public void dispensing() {

    }
}
