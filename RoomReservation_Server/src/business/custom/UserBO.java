package business.custom;

import business.SuperBO;
import dtos.UserDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    public UserDTO searchUser (String uName) throws SQLException;
    public ArrayList<UserDTO> getAllUsers () throws SQLException;
}
