package test;

/**
 * @author footman77
 * @create 2018-11-17 23:00
 */
public class Outor {
    int num = 4;
    class MyIn{}
    public void method(int y){
        int x = 3;
        class Inner{
            void show(){
                System.out.println("show run" + Outor.this.num);
                System.out.println(x);
                System.out.println(y);
            }
        }
        new Inner().show();
    }
}

class InnerClassDemo{
    public static void main(String[] args) {
        new Outor().method(5);
    }
}
