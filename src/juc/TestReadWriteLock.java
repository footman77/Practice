package juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kokio
 * @create 2018-12-24 22:47
 * 写和写之间互斥 写和读之间互斥
 * 读读之间不需要互斥
 * A ReadWriteLock维护一对关联的locks ，一个用于只读操作，一个用于写入。
 * read lock可以由多个线程同时进行，只要没有写。 write lock是独家的。
 */
public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLockDemo.set(new Random().nextInt(10));
            }
        },"Writer").start();


        for(int i = 0; i < 100; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    readWriteLockDemo.get();
                }
            },"Read" + i).start();
        }

    }


}
class ReadWriteLockDemo {

    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();


    //读
    public void get(){
        lock.readLock().lock();//上锁

        try {

            System.out.println(Thread.currentThread().getName() + " :" +number);

        }finally {
            lock.readLock().unlock();//解锁
        }
    }

    //写锁
    public void set(int number){

        lock.writeLock().lock();

        try {

            System.out.println(Thread.currentThread().getName());
            this.number = number;

        }finally {
            lock.writeLock().unlock();
        }
    }


}
