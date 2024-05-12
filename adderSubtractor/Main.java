package adderSubtractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Lock lock = new ReentrantLock();

        Thread adder = new Thread(()->{
            for(int i=0;i<100000;i++)
            {

                count.value++;

            }
        });


        Thread subtrator = new Thread(()->{
            for(int i=0;i<100000;i++)
            {
                lock.lock();
                count.value--;
                lock.unlock();
            }
        });

        adder.start();
        subtrator.start();
        adder.join();
        subtrator.join();

        System.out.println(count.value);


    }
}
