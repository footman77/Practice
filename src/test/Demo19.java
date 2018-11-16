package test;

public class Demo19 {

    public static void main(String[] args) {
        new Dervied();
    }

}
 class Dervied extends Base {

    private String name = "dervied";

    public Dervied() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println(base);
        System.out.println("Dervied tell name: " + name);
    }

    public void printName() {
        System.out.println("Dervied print name: " + name);
    }


}

class Base {

    public String base = "base";

    public Base() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println("Base tell base: " + base);
    }

    public void printName() {
        System.out.println("Base print base: " + base);
    }
}

