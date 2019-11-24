package service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {

    public enum ServiceTypes{
        USER, CUSTOMER, ROOM, RESERVATION;
    }

    public SuperService getService (ServiceTypes type) throws Exception;
}
