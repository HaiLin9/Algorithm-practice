import java.util.LinkedList;
import java.util.Queue;

public class Mian {
    public static Queue<Integer> queue = new LinkedList<>();
    public static Object producer = new Object();
    public static Object consumer = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Producer();
        Thread consumer = new Consumer();
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}

class Producer extends Thread {
    @Override
    public void run() {
        while(true ){
            if(Mian.queue.size()>=10){
                try {
                    Mian.producer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Mian.queue.offer(1);
            Mian.consumer.notify();
        }
    }
}

class Consumer extends Thread {
    @Override
    public void run() {
        while(true ){
            if(Mian.queue.size()<1){
                try {
                    Mian.consumer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int num = Mian.queue.poll();
            Mian.producer.notify();
        }
    }
}

