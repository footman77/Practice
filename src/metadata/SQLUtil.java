package metadata;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static void update(){

    }

    public static void insert(String sql,Object[] values){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            Connection conn = ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

//

            ParameterMetaData pmd = stmt.getParameterMetaData();
            int count = pmd.getParameterCount();

            for(int i=1; i <= count; i++){
                stmt.setObject(i,values[i-1]);
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
