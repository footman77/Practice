package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author footman77
 * @create 2018-10-20 20:16
 */
public class Demo25 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("谁？" );
        System.out.println("在哪");
        System.out.println("干嘛");
        String name = scanner.nextLine();
        String where = scanner.nextLine();
        String dowhat = scanner.nextLine();
        System.out.println("输出信息：");
        System.out.println(name + where + dowhat);
        String info = name + where + dowhat;
        FileWriter fileWriter = new FileWriter("D:/hello.txt");
        fileWriter.write(info);
        fileWriter.close();
    }
}
