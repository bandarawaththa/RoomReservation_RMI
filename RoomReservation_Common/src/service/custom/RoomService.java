package service.custom;

import dtos.RoomDTO;
import service.SuperService;
import java.util.ArrayList;

public interface RoomService extends SuperService {
    public boolean addRoom(RoomDTO room)throws Exception;
    public boolean deleteRoom (RoomDTO room)throws Exception;
    public RoomDTO searchRoom (RoomDTO room)throws Exception;
    public boolean updateRoom (RoomDTO room)throws Exception;
    public ArrayList<RoomDTO> getAllRooms ()throws Exception;
    public ArrayList<RoomDTO> searchAllRooms (int beds, boolean ac, String reserveDate, String releaseDate)throws Exception;
}
