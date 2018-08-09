package statement;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
    public static void main(String[] args) {
//        ddl();

        insert();

    }

    private static void insert() {
        Statement statement = null;
        Connection connection = null;
        //建立链接
        try {
            connection = JdbcUtil.getConnection();

            String sql = "INSERT INTO d_employee VALUES(1,'张三','男',18,'化妆师','ykkkkkk@123.com',123141413);";


            statement = connection.createStatement();

            int i = statement.executeUpdate(sql);

            System.out.println(i);



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(statement,connection);
        }
    }

    private static void ddl() {
        Statement statement = null;
        Connection connection = null;
        //建立链接
        try {
             connection = JdbcUtil.getConnection();

            String sql = "CREATE TABLE d_employee(\n" +
                    "id int PRIMARY KEY,\n" +
                    "name varchar(32),\n" +
                    "gender varchar(2),\n" +
                    "age int,\n" +
                    "position VARCHAR(32),\n" +
                    "email VARCHAR(100),\n" +
                    "phone INT\n" +
                    "\n" +
                    ")";


             statement = connection.createStatement();

            int i = statement.executeUpdate(sql);

            System.out.println(i);



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(statement,connection);
        }
    }
}
