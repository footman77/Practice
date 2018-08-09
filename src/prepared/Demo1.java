package prepared;
/*
使用preparedStatement执行CRUD操作
 */

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo1 {
    public static void main(String[] args) {


        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql = "insert into d_employee values(?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);

            statement.setInt(1,5);
            statement.setString(2,"赵哥");
            statement.setString(3,"男");
            statement.setInt(4, 19);
            statement.setString(5,"老师");
            statement.setString(6,"123141@kk.com");
            statement.setInt(7,12414131);

            int i = statement.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(statement,connection);
        }

    }
}
