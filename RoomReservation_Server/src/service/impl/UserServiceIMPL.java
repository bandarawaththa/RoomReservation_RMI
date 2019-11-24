package service.impl;

import business.BOFactory;
import business.custom.UserBO;
import dtos.UserDTO;
import service.custom.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class UserServiceIMPL extends UnicastRemoteObject implements UserService {
    private UserBO bo = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);

    public UserServiceIMPL() throws RemoteException {}

    @Override
    public UserDTO searchUser(String uName) throws Exception {
        return bo.searchUser(uName);
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() throws Exception {
        return bo.getAllUsers();
    }
}