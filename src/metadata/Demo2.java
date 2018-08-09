package metadata;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) throws SQLException {
        //t1();
       SQLUtil.insert("",new Object[]{} );

    }

    private static void t1() throws SQLException {
        //参数元数据
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        String sql = "insert into d_teacher (id,name,password) values(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

//        stmt.setInt(1,4);
//        stmt.setString(2,"爸爸");
//        stmt.setString(3,"43975");
        Object[] values = new Object[]{5,"小孩","9358934"};
        ParameterMetaData pmd = stmt.getParameterMetaData();
        int count = pmd.getParameterCount();

        for(int i=1; i <= count; i++){
            stmt.setObject(i,values[i-1]);
        }

        stmt.executeUpdate();
    }
}
