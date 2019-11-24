package service.impl;

import business.BOFactory;
import business.custom.RoomBO;
import dtos.RoomDTO;
import service.custom.RoomService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RoomServiceIMPL extends UnicastRemoteObject implements RoomService {
    private RoomBO bO = (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);

    public RoomServiceIMPL() throws RemoteException {}

    @Override
    public boolean addRoom(RoomDTO room) throws Exception {
        return bO.addRoom(room);
    }

    @Override
    public boolean deleteRoom(RoomDTO room) throws Exception {
        return bO.deleteRoom(room);
    }

    @Override
    public RoomDTO searchRoom(RoomDTO room) throws Exception {
        return bO.searchRoom(room);
    }

    @Override
    public boolean updateRoom(RoomDTO room) throws Exception {
        return bO.updateRoom(room);
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() throws Exception {
        return bO.getAllRooms();
    }

    @Override
    public ArrayList<RoomDTO> searchAllRooms(int beds, boolean ac, String reserveDate, String releaseDate) throws Exception {
        return bO.searchAllRooms(beds, ac, reserveDate, releaseDate);
    }
}