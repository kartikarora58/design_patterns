public class HasCoinState implements State{
    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void addCoin() {
        System.out.println("There is already a coin");
    }

    @Override
    public void pressDispenseButton() {
        System.out.println("Dispensing the drink");
        this.dispensing();
    }

    @Override
    public void refundAmount() {
        System.out.println("Amount refund");
        this.vendingMachine.setCurrentState(this.vendingMachine.getIdleState());
    }

    @Override
    public void dispensing() {
        this.vendingMachine.setCans(this.vendingMachine.getCans()-1);
        if(this.vendingMachine.getCans()>0)
            this.vendingMachine.setCurrentState(this.vendingMachine.getIdleState());
        else
            this.vendingMachine.setCurrentState(this.vendingMachine.getOutOfOrder());

    }
}
