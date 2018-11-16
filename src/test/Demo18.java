package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Demo18 {
    public static void main(String[] args) {
//        UUID.randomUUID()
//        Timestamp timestamp = new Timestamp(new Date().getTime());
//        System.out.println(timestamp.toString());

        Baba baba = new Baba();
        String simpleName = baba.getClass().getSimpleName();
        System.out.println(simpleName);

    }
}

class Baba{
    String name;
}