package multiThread;

import java.util.ArrayList;

public class ConsumerProducer {
    public static void main(String[] args) {
            WareHouse wareHouse = new WareHouse();
            Producer p =new Producer(wareHouse);
            Consumer c1 = new Consumer(wareHouse);
            p.start();
            c1.start();
    }
}

class Consumer extends Thread{
    private WareHouse wareHouse;
    public Consumer() {
    }

    public Consumer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while(true) {
            this.wareHouse.get();
        }
    }
}

class Producer extends Thread{
    private WareHouse wareHouse;

    public Producer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    public Producer(){
    }

    @Override
    public void run(){
        while(true){
            this.wareHouse.add();
        }
    }
}

class WareHouse{
    private ArrayList<String> list = new ArrayList<>();

    public synchronized void add()  {
        if(list.size()<1) {
            list.add("a");
            System.out.println("add one");
        } else {
            new Object().notifyAll();
            try{
                wait();
            } catch (Exception e) {
            }
        }
    }

    public synchronized void get() {
        if(list.size()>0) {
            list.remove(0);
            System.out.println("get one");
        } else {
            notifyAll();
            try{
                wait();
            } catch (Exception e ){

            }
        }
    }
}

