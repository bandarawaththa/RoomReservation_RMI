package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface SuperDAO {
    public void setConnection (Connection connection) throws SQLException;
}
