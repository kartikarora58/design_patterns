public class VendingMachine {

    private State idleState;
    private State hasCoinState;
    private State outOfOrder;
    private State currentState;
    private int cans;

    VendingMachine(int cans) {
        this.idleState = new IdleState(this);
        this.hasCoinState = new HasCoinState(this);
        this.outOfOrder = new OutOfOrderState(this);
        this.cans = cans;
        if (this.cans > 0)
            this.currentState = idleState;
        else
            this.currentState = outOfOrder;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getOutOfOrder() {
        return outOfOrder;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getCans() {
        return this.cans;
    }

    public void setCans(int cans) {
        this.cans = cans;
    }

    public void addCoin() {
        this.currentState.addCoin();
    }

    public void pressDispenseButton() {
        this.currentState.pressDispenseButton();
    }

    public void refund() {
        this.currentState.refundAmount();
    }

}
