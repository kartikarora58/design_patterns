package blockingQueue;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Insert implements Runnable{

    final Queue<Object> q;
    int size;
    Semaphore produce;
    Semaphore consume;

    Insert(Queue<Object> q,int size,Semaphore produce, Semaphore consume)
    {
        this.q = q;
        this.size = size;
        this.produce = produce;
        this.consume = consume;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                produce.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(q.size()<this.size)
            {
                q.add(new Object());
                System.out.println("inserted size-"+q.size());
            }
            consume.release();
        }


    }
}
