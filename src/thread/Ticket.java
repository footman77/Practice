package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author footman77
 * @create 2018-10-11 10:28
 */
public class Ticket implements Runnable{

    private int ticket = 100;

    private Lock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(ticket > 0){

                    System.out.println(Thread.currentThread().getName() + "当前正在卖第" + ticket + "票");
                    ticket--;
                }
            }finally {
                lock.unlock();

            }

        }

    }

//    int ticket = 100;
//    @Override
//    public void run() {
//
//        while (true){
//            synchronized (Ticket.class){
//                if(ticket > 0){
//                    System.out.println(Thread.currentThread().getName() + "当前正在卖第" + ticket + "票");
//                    ticket--;
//                }
//            }
//
//        }
//    }
}
