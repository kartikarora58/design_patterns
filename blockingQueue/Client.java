package blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> q = new LinkedList<>();
        Semaphore produce = new Semaphore(6);
        Semaphore consume = new Semaphore(0);
        Insert insert = new Insert(q,6,produce,consume);
        Delete delete = new Delete(q,6,produce,consume);
        for(int i=0;i<6;i++)
        {
            Thread thread = new Thread(insert);
            thread.start();
        }
        for(int i=0;i<6;i++)
        {
            Thread thread = new Thread(delete);
            thread.start();
        }


    }
}
