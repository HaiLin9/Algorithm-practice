package multiThread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {
    private int capacity;
    LinkedList<E> queue = new LinkedList<>();
    ReentrantLock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();
    BlockingQueue(int capacity){
        this.capacity = capacity;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            if(queue.size()>=capacity){
                full.await();
            } else {
                queue.addLast(e);
                empty.signal();
            }
        } finally {
            lock.unlock();
        }
    }




}
