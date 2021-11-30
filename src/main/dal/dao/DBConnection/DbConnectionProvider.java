package dal.dao.DBConnection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class DbConnectionProvider {

    private SQLServerDataSource ds;

    private void DBConnectionProvider() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("MyTunesGP6");
        ds.setUser("CSe21B_29");
        ds.setPassword("CSe21B_29");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }

    private Connection getConnection() throws SQLServerException {
        return ds.getConnection();
    }
}
