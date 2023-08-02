import java.lang.invoke.VarHandle;

public class Main {
    public static void main(String[] args)
    {
        VendingMachine machine = new VendingMachine(2);
        machine.addCoin();
        machine.pressDispenseButton();
        machine.pressDispenseButton();
        machine.addCoin();
        machine.addCoin();
        machine.pressDispenseButton();
        machine.pressDispenseButton();

    }
}