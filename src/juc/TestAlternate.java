package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kokio
 * @create 2018-12-24 22:06
 */
public class TestAlternate {

    public static void main(String[] args) {
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10;i++){
                    alternateDemo.loopA(i);

                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10;i++){
                    alternateDemo.loopB(i);

                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10;i++){
                    alternateDemo.loopC(i);

                }
            }
        },"C").start();
    }

}


class AlternateDemo {

    private int number = 1;

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();




    public void loopA(int totalLoop){
        lock.lock();

        try {

            if(number != 1){
                condition1.await();
            }
            for(int i = 0; i < 1; i++){
                System.out.println(Thread.currentThread().getName() + ":A");
            }
            number = 2;
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void loopB(int totalLoop){
        lock.lock();

        try {

            if(number != 2){
                condition2.await();
            }
            for(int i = 0; i < 1; i++){
                System.out.println(Thread.currentThread().getName() + ":B");
            }
            number = 3;
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void loopC(int totalLoop){
        lock.lock();

        try {

            if(number != 3){
                condition3.await();
            }
            for(int i = 0; i < 1; i++){
                System.out.println(Thread.currentThread().getName() + ":C");
            }
            number = 1;
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
