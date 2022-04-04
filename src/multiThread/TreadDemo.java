package multiThread;

/**
 * Java实现两个线程交替打印1-100
 */
class PrintDemo implements Runnable {
    private int i = 1;
    @Override
    public void run() {
        synchronized (this) {
            while(true) {
                notify();
                if(i<=100) {
                    System.out.println("thread:"+Thread.currentThread().getName() + " print:" + i);
                    i++;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class TreadDemo {
    public static void main(String[] args) {
        PrintDemo pt = new PrintDemo();
        Thread thread1 = new Thread(pt);
        Thread thread2 = new Thread(pt);
        thread1.start();
        thread2.start();
    }
}
