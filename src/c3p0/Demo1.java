package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo1 {
    private static String url = "jdbc:mysql://localhost:3306/demo1?serverTimezone=GMT&useSSL=true";
    private static String user = "root";
    private static String password = "root";
    private static String driverClass = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) throws Exception {
        //创建连接池
        //test1();

        ComboPooledDataSource cds = new ComboPooledDataSource();


        for(int i = 0; i < 10; i++){
            Connection connection = cds.getConnection();
            System.out.println(connection);
        }


    }

    private static void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cds = new ComboPooledDataSource();
        //设置连接参数
        cds.setJdbcUrl(url);
        cds.setUser(user);
        cds.setPassword(password);
        cds.setDriverClass(driverClass);

        //设置连接池相关参数

        cds.setInitialPoolSize(6);
        cds.setMaxPoolSize(10);
        cds.setCheckoutTimeout(3000);
        for(int i = 0; i < 10; i++){
            Connection connection = cds.getConnection();
            System.out.println(connection);
        }
    }
}
