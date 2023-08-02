public class VendingMachine {
    private StateEnum currentState = StateEnum.OutOfOrder;
    private int cans;
    VendingMachine(int cans)
    {
        this.cans = cans;
        if (cans>0){
            this.currentState = StateEnum.Idle;
        }
    }

    public void addCoin()
    {
        if (this.currentState == StateEnum.OutOfOrder) {
            System.out.println("Out of cans");
        }
        else if(this.currentState == StateEnum.Idle)
        {
            System.out.println("Coin inserted ! Please press button to dispense");
            this.currentState = StateEnum.HasCoin;
        }
        else if(this.currentState == StateEnum.HasCoin)
        {
            System.out.println("You can't insert a coin while there is already a coin-ejecting");

        }
    }

    public void pressDispenseButton()
    {
        if (this.currentState == StateEnum.OutOfOrder)
            System.out.println("Out of cans");
        else if(this.currentState == StateEnum.Idle)
        {
            System.out.println("Please add coin to get a drink");
        }
        else if(this.currentState == StateEnum.HasCoin)
        {
            System.out.println("Dispensing a can");
            this.currentState = StateEnum.Dispensing;
            this.dispensing();
        }

    }
    private void dispensing()
    {
        this.cans--;
        System.out.println("Here is your can !");
        if(this.cans>0)
            this.currentState = StateEnum.Idle;
        else
            this.currentState = StateEnum.OutOfOrder;
    }
}
