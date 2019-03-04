package juc;

/**
 * @author kokio
 * @create 2018-12-24 18:30
 * 生产者和消费者
 */
public class TestProductorAndConsumer {

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

////店员
//class Clerk {
//    private int product = 0;
//
//    //进货
//    public synchronized void get(){
//        while (product >= 1){   //为了避免虚假唤醒问题，应该总是使用在循环中
//            System.out.println("产品已满");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + ":"+ ++product);
//        this.notifyAll();
//
//    }
//
//    //卖货
//    public synchronized void sale(){
//        while (product <= 0){
//            System.out.println("没有产品");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + --product);
//        this.notifyAll();
//
//    }
//}
////生产者
//class Productor implements Runnable {
//
//    private Clerk clerk;
//
//    public Productor(Clerk clerk){
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//
//        for(int i = 0; i < 20; i++){
//
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            clerk.get();
//        }
//    }
//
//}
//
//class Consumer implements Runnable {
//
//    private Clerk clerk;
//
//    public Consumer(Clerk clerk){
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for(int i = 0; i < 20; i++){
//            clerk.sale();
//        }
//    }
//}
