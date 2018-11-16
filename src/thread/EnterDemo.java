package thread;

/**
 * @author footman77
 * @create 2018-10-11 17:06
 */
public class EnterDemo {
    public static void main(String[] args) {

        Enter enter = new Enter();

        Thread t1 = new Thread(enter, "前门");
        Thread t2 = new Thread(enter, "后门");

        t1.start();
        t2.start();
    }
}
