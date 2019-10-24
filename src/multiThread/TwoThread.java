package multiThread;

public class TwoThread {
    public static void main(String[] args){
        PrintThread p1 = new PrintThread();
        PrintThread p2 = new PrintThread();
        p1.start();
        p2.start();
    }


}

class PrintThread extends Thread{
    public static int num = 1;

    @Override
    public void run(){
        synchronized (PrintThread.class){
            while(num<=100){
                System.out.println("Thread: " +Thread.currentThread().getName() + " num: " + num++);
                PrintThread.class.notifyAll();
                try{
                    PrintThread.class.wait();
                } catch (InterruptedException e ){

                }
            }
        }
    }
}
