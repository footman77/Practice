package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo1 {

    //连接数据库字符串
    private static String url = "jdbc:mysql://localhost:3306/demo1?serverTimezone=GMT&useSSL=true";
                            //jdbc协议+数据库协议+主机地址+端口+连接的数据库
    private static String user = "root";

    private  static String password = "root";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //t1();

        //t2();
        //注册驱动,调用，反射获取类的对象
        Class.forName("com.mysql.cj.jdbc.Driver");
        //使用驱动管理类获得链接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);


    }

    //使用驱动管理类，连接数据库
    private static void t2() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();

        //注册驱动程序
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    private static void t1() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();

        Properties prop = new Properties();

        prop.setProperty("user", user);
        prop.setProperty("password", password);

        //连接
        Connection conn = driver.connect(url, prop);

        System.out.println(conn);
    }
}
