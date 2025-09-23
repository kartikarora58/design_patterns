import java.util.ArrayList;
import java.util.List;

public class Main {

    interface Test{
        public void check();
    }

    class Original implements Test{
        int val;

        public void setVal(int x)
        {
            this.val = x;
        }

        public void check(){

        }


    }


    private Test getOb()
    {
        Test test = new Original();
        ((Original)test).setVal(10);
        return test;

    }

    public static void main(String[] args) {

        Main ob = new Main();

        Test t = ob.getOb();
        System.out.println("hi");


    }
}