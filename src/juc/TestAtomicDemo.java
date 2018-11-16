package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author footman77
 * @create 2018-10-31 22:24
 */
public class TestAtomicDemo {
    public static void main(String[] args) {

        AtomicDemo atomicDemo = new AtomicDemo();
        for(int i = 0 ; i < 10; i++){
            new Thread(atomicDemo).start();

        }
    }



}

class AtomicDemo implements Runnable{

//    private volatile int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber() );
    }



    public int getSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}
