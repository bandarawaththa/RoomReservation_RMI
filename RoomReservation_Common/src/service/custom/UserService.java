package service.custom;

import dtos.UserDTO;
import service.SuperService;
import java.util.ArrayList;

public interface UserService extends SuperService {
    public UserDTO searchUser (String uName) throws Exception;
    public ArrayList<UserDTO> getAllUsers () throws Exception;
}