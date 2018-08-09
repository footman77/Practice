package prepared;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = JdbcUtil.getConnection();

            String sql = "select * from d_user where name = '张三' and password = 123456;";

            statement = connection.createStatement();
            resultSet= statement.executeQuery(sql);
            if(resultSet.next()){
                System.out.println("登陆成功");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,statement,connection);
        }


    }
}
