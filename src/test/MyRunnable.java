package test;

/**
 * @author footman77
 * @create 2018-10-11 0:40
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "第二次啊哈哈哈");
    }
}
