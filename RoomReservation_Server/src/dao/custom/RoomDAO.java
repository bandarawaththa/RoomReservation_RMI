package dao.custom;

import dao.CrudDAO;
import entities.RoomEntity;
import java.util.ArrayList;

public interface RoomDAO extends CrudDAO<RoomEntity> {
    public ArrayList<RoomEntity> searchAll(int beds, int ac, String reserveDate, String releaseDate) throws Exception;
}