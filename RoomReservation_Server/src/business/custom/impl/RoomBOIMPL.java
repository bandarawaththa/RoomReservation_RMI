package business.custom.impl;

import business.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dbHandler.DBCon;
import dtos.RoomDTO;
import entities.RoomEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class RoomBOIMPL implements RoomBO {
    private RoomDAO dao = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean addRoom(RoomDTO room) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRoom(RoomDTO room) throws Exception {
        return false;
    }

    @Override
    public RoomDTO searchRoom(RoomDTO room) throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()) {
            dao.setConnection(connection);
            RoomEntity temp = new RoomEntity();
            temp.setRoomNumber(room.getRoomNumber());
            RoomEntity entity = dao.search(temp);
            return (null != entity) ? new RoomDTO(entity.getRoomNumber(), entity.getBeds(), entity.getFloor(), entity.isAc() == 1 ? true : false, entity.isAvailable() == 1 ? true : false, entity.getPrice()) : null;
        }
    }

    @Override
    public boolean updateRoom(RoomDTO room) throws Exception {
        return false;
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()){
            dao.setConnection(connection);
            ArrayList<RoomEntity> allEntities = dao.getAll();
            ArrayList<RoomDTO> allDTOS = new ArrayList<>();
            for (RoomEntity entity :
                    allEntities) {
                allDTOS.add(new RoomDTO(entity.getRoomNumber(), entity.getBeds(), entity.getFloor(), entity.isAc() == 1 ? true : false, entity.isAvailable() == 1 ? true : false, entity.getPrice()));
            }
            return allDTOS;
        }
    }

    @Override
    public ArrayList<RoomDTO> searchAllRooms(int beds, boolean ac, String reserveDate, String releaseDate) throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()){
            dao.setConnection(connection);
            ArrayList<RoomEntity> allEntities = dao.searchAll(beds, ((true == ac) ? 1 : 0), reserveDate, releaseDate);
            ArrayList<RoomDTO> allDTOS = new ArrayList<>();
            for (RoomEntity entity :
                    allEntities) {
                allDTOS.add(new RoomDTO(entity.getRoomNumber(), entity.getBeds(), entity.getFloor(), entity.isAc() == 1 ? true : false, entity.isAvailable() == 1 ? true : false, entity.getPrice()));
            }
            return allDTOS;
        }
    }
}