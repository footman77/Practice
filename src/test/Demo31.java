package test;

/**
 * @author footman77
 * @create 2018-11-27 0:40
 */
public class Demo31 {

    public static void main(String[] args) {
        Human human = new Human("kokio",18);
        System.out.println(human.name);
        human.add();
    }
}

class God{
    String name;
    int age;

    public God() {
    }

    public God(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void run(){
        System.out.println("this is running");
    }

}

class Human extends God{
    public Human(String name,int age){
        super(name,age);
    }

    public void add(){
        super.run();
        System.out.println("hello");
    }

}