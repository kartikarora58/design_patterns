
class EvenPrinter extends Thread{
    final boolean[] flag;
    int idx;

    EvenPrinter(int idx, boolean[] flag)
    {
        this.idx = idx;
        this.flag = flag;
    }
    public void run()
    {
        synchronized (flag)
        {
            while(idx<=10)
            {
                if(flag[0]) {
                    System.out.println("even-"+idx);
                    idx += 2;
                    flag[0] = !flag[0];
                    flag.notify();
                }
                else{
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}

class OddPrinter extends Thread{
    final boolean[] flag;
    int idx;

    OddPrinter(int idx, boolean[] flag)
    {
        this.idx = idx;
        this.flag = flag;
    }

    public void run()
    {
        synchronized (flag)
        {
            while(idx<=10)
            {
                if(!flag[0]) {
                    System.out.println("odd-"+idx);
                    idx += 2;
                    flag[0] = !flag[0];
                    flag.notify();
                }
                else{
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
public class Sample{
    public static void main(String[] args) throws InterruptedException {
        boolean[] flag = {true};
        EvenPrinter evenPrinter = new EvenPrinter(2,flag);
        OddPrinter oddPrinter = new OddPrinter(1,flag);
        evenPrinter.start();
        oddPrinter.start();

        evenPrinter.join();
        oddPrinter.join();

    }
}