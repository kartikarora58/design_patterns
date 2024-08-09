package blockingQueue;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Delete implements Runnable {
    final Queue<Object> q;
    int size;
    Semaphore produce;
    Semaphore consume;

    Delete(Queue<Object> q, int size, Semaphore produce, Semaphore consume) {
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
                consume.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(q.size()>0)
            {
                q.remove();
                System.out.println("deleted size-"+q.size());
            }
            produce.release();
        }

    }


}
