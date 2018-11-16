package test;

/**
 * @author footman77
 * @create 2018-11-08 14:37
 */
public class Demo30 {
    public static void main(String[] args) {
        System.out.println(Singleton.count_1);
        System.out.println(Singleton.count_2);
    }
}
class Singleton {
    private static Singleton singleton = new Singleton();
    public static int count_1;
    public static int count_2 = 0;


    static {
        System.out.println("----1");
        count_1++;
        count_2++;
    }
    private Singleton() {
        System.out.println("----2");
        count_1++;
        count_2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
