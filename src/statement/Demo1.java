package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

    private static String url = "jdbc:mysql://localhost:3306/demo1?serverTimezone=GMT&useSSL=true";

    private static String user = "root";

    private  static  String password = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "CREATE TABLE d_teacher (id int PRIMARY KEY, name VARCHAR(32), password VARCHAR(32))";

        Statement statement = connection.createStatement();

        int i = statement.executeUpdate(sql);

        System.out.println(i);

        //关闭资源
        statement.close();

        connection.close();

    }
}
