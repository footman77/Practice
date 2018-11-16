package thread;

/**
 * @author footman77
 * @create 2018-10-11 16:40
 */
public class LotteryDemo {
    public static void main(String[] args) {

        Lottery lottery = new Lottery();

        Thread thread1 = new Thread(lottery, "抽奖箱1");
        Thread thread2 = new Thread(lottery, "抽奖箱2");

        thread1.start();
        thread2.start();
    }
}
