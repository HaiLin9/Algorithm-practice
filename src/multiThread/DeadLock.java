package multiThread;

public class DeadLock {
    public static void main(String[] args){
        Object o1 = new Object();
        Object o2 = new Object();
        Thread1 t1 = new Thread1(o1,o2);
        Thread2 t2 = new Thread2(o1,o2);
        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread
{
    Object o1;
    Object o2;

    public Thread1(){
    }

    public Thread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run(){
        synchronized (o1){
            System.out.println("1...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                System.out.println("2...");
            }
        }

    }
}

class Thread2 extends Thread
{
    Object o1;
    Object o2;

    public Thread2(){
    }

    public Thread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run(){
        synchronized (o2) {
            System.out.println("1...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("2...");
            }
        }
    }
}
