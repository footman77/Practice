package test;

import java.util.Arrays;

class Person{
    static int count = 0;
    //构造函数
    Person(){
        count++;

    }

    public static void num(){
        System.out.print(count);
    }


}

public class Demo {
    public static void main(String[] args){
//        Person p1 = new Person();
//
//        Person p2 = new Person();
//        Person p3 = new Person();
//
//        Person.num();
        int[] arr = {12, 3, 5};
        System.out.println(Arrays.toString(arr));
    }

}
