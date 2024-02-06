package VendingMachine;


public class ProductAlreadyAvailable extends Exception{

    ProductAlreadyAvailable(String errMessage)
    {
        super(errMessage);
    }

}
