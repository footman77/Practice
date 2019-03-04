package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kokio
 * @create 2018-12-24 18:30
 * 生产者和消费者
 */
public class TestProductorAndConsumerForLock {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread tproductor = new Thread(productor,"生产者");
        Thread tconsumer = new Thread(consumer,"消费者");

        Thread tproductor1 = new Thread(productor,"生产者");
        Thread tconsumer1 = new Thread(consumer,"消费者");

        tproductor.start();
        tconsumer.start();
        tproductor1.start();
        tconsumer1.start();

    }


}

//店员
class Clerk {
    private int product = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    //进货
    public  void get(){
        lock.lock();
        try {
            while (product >= 1){   //为了避免虚假唤醒问题，应该总是使用在循环中
                System.out.println("产品已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":"+ ++product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    //卖货
    public  void sale(){

        lock.lock();

        try {

            while (product <= 0){
                System.out.println("没有产品");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }


    }
}

//生产者
class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {

        for(int i = 0; i < 20; i++){

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.get();
        }
    }

}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            clerk.sale();
        }
    }
}
