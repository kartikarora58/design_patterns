package adderSubtractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// we can use synchronized ke
public class MainV2 {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Lock lock = new ReentrantLock();
        Thread adder = new Thread(()->{
            for(int i=0;i<100000;i++)
            {
                synchronized (count) {
                    count.value++;
                }

            }
        });
        Thread subtrator = new Thread(()->{
            for(int i=0;i<100000;i++)
            {
                synchronized (count) {
                    count.value--;
                }
            }
        });

        adder.start();
        subtrator.start();
        adder.join();
        subtrator.join();

        System.out.println(count.value);
    }
}
