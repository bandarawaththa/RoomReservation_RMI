package dao.custom.impl;

import dao.custom.ReservationDAO;
import entities.ReservationEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAOIMPL implements ReservationDAO {
    @Override
    public boolean add(ReservationEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ReservationEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(ReservationEntity entity) throws SQLException {
        return false;
    }

    @Override
    public ReservationEntity search(ReservationEntity entity) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<ReservationEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {

    }
}