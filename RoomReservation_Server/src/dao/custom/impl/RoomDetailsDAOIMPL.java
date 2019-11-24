package dao.custom.impl;

import dao.custom.RoomDetailsDAO;
import entities.RoomDetailsEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDetailsDAOIMPL implements RoomDetailsDAO {
    @Override
    public boolean add(RoomDetailsEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(RoomDetailsEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(RoomDetailsEntity entity) throws SQLException {
        return false;
    }

    @Override
    public RoomDetailsEntity search(RoomDetailsEntity entity) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<RoomDetailsEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {

    }
}