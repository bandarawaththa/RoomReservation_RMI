package dao;

import dao.custom.impl.*;

public class DAOFactory {
    public static DAOFactory factory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return (null == factory) ? (factory = new DAOFactory()) : factory;
    }

    public enum DAOTypes{
        USER, CUSTOMER, ROOM, RESERVATION, ROOMDETAILS;
    }

    public SuperDAO getDAO (DAOTypes type) {
        switch (type){
            case USER:
                return new UserDAOIMPL();
            case CUSTOMER:
                return new CustomerDAOIMPL();
            case ROOM:
                return new RoomDAOIMPL();
            case RESERVATION:
                return new ReservationDAOIMPL();
            case ROOMDETAILS:
                return new RoomDetailsDAOIMPL();
            default:
                return null;
        }
    }
}