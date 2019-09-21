package multiThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 毕向东多线程  Lock demo
 */
public class ProducerConsumerLockDemo {
    public static void main(String[] args){
        Resource r =new Resource();
        Producer p = new Producer(r);
        Consumer c = new Consumer(r);
        Thread t1= new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3= new Thread(c);
        Thread t4 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Resource2{
    private String name;
    private int count = 1;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition  condition_pro = lock.newCondition();
    private Condition  condition_con = lock.newCondition();


    public synchronized void set(String name){
        lock.lock();
        try{
            while(flag) {
                try{
                    condition_pro.await();
                } catch (InterruptedException e){

                }
            }
            this.name = name + "--" + count++;
            System.out.println(Thread.currentThread().getName() + "生产者。。。" + this.name);
            flag =true;
            condition_con.signal();
        } finally {
            lock.unlock();
        }

    }

    public synchronized void out(){
        lock.lock();
        try{
            while(!flag){
                try{
                    condition_con.await();
                } catch (InterruptedException e){

                }
            }
            System.out.println(Thread.currentThread().getName() + "消费者。。。" + this.name);
            flag = false;
            condition_pro.signal();
        } finally {
            lock.unlock();
        }

    }
}


class Producer2 implements  Runnable{
    private Resource2 res;

    Producer2(Resource2 res){
        this.res = res;
    }

    @Override
    public void run(){
        while (true){
            res.set("商品");
        }
    }
}


class Consumer2 implements Runnable{
    private Resource2 res;

    Consumer2(Resource2 res){
        this.res = res;
    }

    @Override
    public void run(){
        while (true){
            res.out();
        }
    }
}
