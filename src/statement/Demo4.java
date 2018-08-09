package statement;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class Demo4 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try {
             connection = JdbcUtil.getConnection();

             String sql = "SELECT * from d_employee;";

             statement = connection.createStatement();

             resultSet = statement.executeQuery(sql);

             while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String position = resultSet.getString("position");
                String email = resultSet.getString("email");
                int phone = resultSet.getInt("phone");
                 System.out.println("id:" + id + "name:" + name + "gender:" + gender + "age:" + age + "position:" + position + "email:" + email + "phone:" + phone );
             }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,statement,connection);
        }


    }
}
