public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(10);
        machine.pressDispenseButton();
        machine.addCoin();
        machine.pressDispenseButton();
        machine.refund();
        machine.addCoin();
        machine.refund();
    }
}