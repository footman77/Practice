package thread;

/**
 * @author footman77
 * @create 2018-10-11 10:29
 */
public class ThreadDemo {



    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        Thread thread01 = new Thread(ticket);
        Thread thread02 = new Thread(ticket);
        Thread thread03 = new Thread(ticket);
        Thread.yield();
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
