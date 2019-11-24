package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RoomDAO;
import entities.RoomEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOIMPL implements RoomDAO {
    private Connection connection;

    @Override
    public ArrayList<RoomEntity> searchAll(int beds, int ac, String reserveDate, String releaseDate) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Rooms WHERE ID NOT IN(SELECT RoomID FROM RoomDetails WHERE ? BETWEEN ReserveDate AND ReleaseDate) && ID NOT IN(SELECT RoomID FROM RoomDetails WHERE ? BETWEEN ReserveDate AND ReleaseDate) && Beds = ? && AC = ?;", connection, reserveDate, releaseDate, beds, ac);
        ArrayList<RoomEntity> allEntitiies = new ArrayList<>();
        while (rst.next()){
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setRoomNumber(rst.getInt("ID"));
            roomEntity.setBeds(rst.getInt("Beds"));
            roomEntity.setFloor(rst.getInt("Floor"));
            roomEntity.setAc(rst.getInt("AC"));
            roomEntity.setAvailable(rst.getInt("Service"));
            roomEntity.setPrice(rst.getDouble("Price"));
            allEntitiies.add(roomEntity);
        }
        return allEntitiies;
    }

    @Override
    public boolean add(RoomEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(RoomEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(RoomEntity entity) throws SQLException {
        return false;
    }

    @Override
    public RoomEntity search(RoomEntity entity) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Rooms WHERE ID = ?", connection, entity.getRoomNumber());
        while (rst.next()){
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setRoomNumber(rst.getInt("ID"));
            roomEntity.setBeds(rst.getInt("Beds"));
            roomEntity.setFloor(rst.getInt("Floor"));
            roomEntity.setAc(rst.getInt("AC"));
            roomEntity.setAvailable(rst.getInt("Service"));
            roomEntity.setPrice(rst.getDouble("Price"));
            return roomEntity;
        }
        return null;
    }

    @Override
    public ArrayList<RoomEntity> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Rooms", connection);
        ArrayList<RoomEntity> allEntitiies = new ArrayList<>();
        while (rst.next()){
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setRoomNumber(rst.getInt("ID"));
            roomEntity.setBeds(rst.getInt("Beds"));
            roomEntity.setFloor(rst.getInt("Floor"));
            roomEntity.setAc(rst.getInt("AC"));
            roomEntity.setAvailable(rst.getInt("Service"));
            roomEntity.setPrice(rst.getDouble("Price"));
            allEntitiies.add(roomEntity);
        }
        return allEntitiies;
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }
}