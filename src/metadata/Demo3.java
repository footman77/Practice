package metadata;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo3 {
    public static void main(String[] args) {

        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            Connection conn = ds.getConnection();

            String sql = "select * from d_teacher where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ParameterMetaData pmd = stmt.getParameterMetaData();
            int count = pmd.getParameterCount();

            Object[] values = new Object[]{1};
            for(int i = 1; i <= count; i++){
                stmt.setObject(i,values[i -1]);

            }
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
