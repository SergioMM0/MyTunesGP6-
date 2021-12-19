package dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

/**
 * Author: Sergio M.
 * @SergioMM0 on Github
 */

public class DBConnectionProvider {

    private SQLServerDataSource ds;

    /**
     * Constructor which holds the information of the server that user is connecting to.
     */

    public DBConnectionProvider() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("MyTunesGP6");
        ds.setUser("CSe21B_29");
        ds.setPassword("CSe21B_29");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }

    /**
     * Attempts to connect to SQL Server given.
     * @return Connection
     * @throws SQLServerException if needed.
     */

    public Connection getConnection() throws SQLServerException {
        return ds.getConnection();
    }
}
