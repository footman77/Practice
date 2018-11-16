package test;

import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * @author footman77
 * @create 2018-10-24 15:35
 */
public class Collection {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("你好啊");
        list.add("不好啊");
        list.add("shenme a ！！");

//        System.out.println(list);
        list.forEach(System.out::println);
    }

}
