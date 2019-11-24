package business.custom.impl;

import business.custom.UserBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dbHandler.DBCon;
import dtos.UserDTO;
import entities.UserEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOIMPL implements UserBO {
    UserDAO dao = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public UserDTO searchUser(String uName) throws SQLException {
        try (Connection connection = DBCon.getInstance().getConnection()){
            dao.setConnection(connection);
            UserEntity temp = new UserEntity();
            temp.setuName(uName);
            UserEntity search = dao.search(temp);
            UserDTO dto = new UserDTO();
            dto.setId(search.getId());
            dto.setUName(search.getuName());
            dto.setPW(search.getPw());
            return (null == search) ? null : dto;
        }
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() throws SQLException {
        try (Connection connection = DBCon.getInstance().getConnection()){
            dao.setConnection(connection);
            ArrayList<UserEntity> allEntities = dao.getAll();
            ArrayList<UserDTO> allDTO = new ArrayList<>();
            for (UserEntity entity :
                    allEntities) {
                UserDTO dto = new UserDTO();
                dto.setId(entity.getId());
                dto.setUName(entity.getuName());
                dto.setPW(entity.getPw());
                allDTO.add(dto);
            }
            return allDTO;
        }
    }
}