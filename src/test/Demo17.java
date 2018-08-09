package test;

import java.util.ArrayList;
import java.util.HashSet;

public class Demo17 {

    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("hao");
        strings.add("23");
        strings.add("ho");
        strings.add("bao");

        String s = strings.toString();


        System.out.println(strings.toString());

        ArrayList<String> a = new ArrayList<>(strings);

        System.out.println(a);
    }
}
