package pool;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Demo1 {
    private static String url = "jdbc:mysql://localhost:3306/demo1?serverTimezone=GMT&useSSL=true";
    private static String user = "root";
    private static String password = "root";
    private static String driverClass = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
       // test1();  没有配置文件的做法

        //创建dbcp连接池对象
        //BasicDataSource bds = new BasicDataSource();





        /*
        读取jdbc.properties文件内容
        dbcp可以自动识别每个配置信息，但是约定前提：配置文件的key名称和设置的方法的名称保持一致
         */


        //获取链接
        try {
            //使用配置参数的方式
            //使用工厂类来创建dbcp连接池对象,读取配置文件

            Properties prop = new Properties();

            //FileInputStream in = new FileInputStream("./src/jdbc.properties");
            //使用类路径读取配置文件
            InputStream in = Demo1.class.getResourceAsStream("/jdbc.properties");


            prop.load(in);
            BasicDataSource bds = (BasicDataSource) BasicDataSourceFactory.createDataSource(prop);
            for(int i = 0; i < 10; i++){
                Connection connection = bds.getConnection();//返回的connection对象不是真实的，而是代理之后的
                System.out.println(connection);
//                if(i == 3){
//                    connection.close();
//                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        //创建dbcp连接池对象
        BasicDataSource bds = new BasicDataSource();

        //设置链接参数
        bds.setUrl(url);
        bds.setUsername(user);
        bds.setPassword(password);
        bds.setDriverClassName(driverClass);

        //连接池参数
        bds.setInitialSize(5);//初始链接
        bds.setMaxActive(10);//最大链接
        bds.setMaxWait(3000);//当超过最大链接数，最大等待时机啊


        //获取链接
        try {
            for(int i = 0; i < 10; i++){
                Connection connection = bds.getConnection();//返回的connection对象不是真实的，而是代理之后的
                System.out.println(connection);
                if(i == 3){
                    connection.close();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
