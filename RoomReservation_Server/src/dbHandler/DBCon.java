package dbHandler;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBCon {
    private static DBCon dbCon;
    private BasicDataSource basicDataSource;

    private DBCon () {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/RoomReserv");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(5);
    }

    public static DBCon getInstance(){
        return (null == dbCon) ? (dbCon = new DBCon()) : dbCon;
    }

    public Connection getConnection () throws SQLException {
        return basicDataSource.getConnection();
    }
}