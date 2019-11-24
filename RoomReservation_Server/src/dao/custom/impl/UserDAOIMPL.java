package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.UserDAO;
import entities.UserEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOIMPL implements UserDAO {
    private Connection connection;

    @Override
    public boolean add(UserEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(UserEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(UserEntity entity) throws SQLException {
        return false;
    }

    @Override
    public UserEntity search(UserEntity entity) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Users WHERE UName = ?", connection, entity.getuName());
        UserEntity userEntity = null;
        while (rst.next()){
            userEntity = new UserEntity();
            userEntity.setId(rst.getInt("ID"));
            userEntity.setuName(rst.getString("UName"));
            userEntity.setPw(rst.getString("PW"));
        }
        return userEntity;
    }

    @Override
    public ArrayList<UserEntity> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Users", connection);
        ArrayList<UserEntity> allEntitiies = new ArrayList<>();
        while (rst.next()){
            UserEntity entity = new UserEntity();
            entity.setId(rst.getInt("ID"));
            entity.setuName(rst.getString("UName"));
            entity.setPw(rst.getString("PW"));
            allEntitiies.add(entity);
        }
        return allEntitiies;
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }
}