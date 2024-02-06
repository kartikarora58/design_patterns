package VendingMachine;

//start()
//addCoin()
//cancel()
//selectProduct()
//addProduct()
//cancel()
//dispense()
public interface State {

    public void start();
    public void addCoin();
    public void cancel();
    public void selectProduct();
    public void dispense();

}
