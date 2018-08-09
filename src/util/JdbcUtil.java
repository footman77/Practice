package util;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    //url
    private static String url = null;
    //用户名
    private static String user = null;
    //密码
    private  static  String password = null;

    private  static  String driverClass = null;


    /*
    注册驱动程序，只执行一次，使用静态代码块
     */
    static{





        try {

             /*
        读取jdbc.properties文件
         */
            //1）创建Properties对象
            Properties prop = new Properties();
            //构造输入流
            FileInputStream in = new FileInputStream("./src/jdbc.properties");

            //加载文件
            prop.load(in);

            //读取文件
            url         = prop.getProperty("url");
            user        = prop.getProperty("user");
            password    = prop.getProperty("password");
            driverClass = prop.getProperty("driverClass");
            System.out.println(url);
            System.out.println(user);
            System.out.println(password);
            System.out.println(driverClass);

            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return  connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /*
    释放资源的方法
     */
    public static void close(Statement statement,Connection connection){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw  new RuntimeException(e);
            }
        }


    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw  new RuntimeException(e);
            }
        }


    }


}
