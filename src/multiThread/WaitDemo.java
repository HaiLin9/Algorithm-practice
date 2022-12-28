package multiThread;

public class WaitDemo {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.start();
        t2.start();
    }
}


class Number implements Runnable{
    static int i =1;

    @Override
    public void run() {
        synchronized (Number.class) {
            while(i<=100) {
                Number.class.notify();
                System.out.println(Thread.currentThread().getName()+":"+ i++);
                if (i>=100){
                    break;
                }
                try {
                    Number.class.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
