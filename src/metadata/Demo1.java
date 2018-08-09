package metadata;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
//        System.out.println(conn);

        DatabaseMetaData dbmd = conn.getMetaData();

        System.out.println(dbmd.getDatabaseProductName());
        System.out.println(dbmd.getDatabaseMajorVersion());
        System.out.println(dbmd.getDatabaseMinorVersion());
        System.out.println(dbmd.getDriverMajorVersion());
        System.out.println(dbmd.getDriverMinorVersion());

    }



}
