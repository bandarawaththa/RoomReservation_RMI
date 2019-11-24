package service;

import service.impl.CustomerServiceIMPL;
import service.impl.ReservationServiceIMPL;
import service.impl.RoomServiceIMPL;
import service.impl.UserServiceIMPL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryIMPL extends UnicastRemoteObject implements ServiceFactory {

    public static ServiceFactoryIMPL serviceFactory;

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type){
            case USER:
                return new UserServiceIMPL();
            case CUSTOMER:
                return new CustomerServiceIMPL();
            case ROOM:
                return new RoomServiceIMPL();
            case RESERVATION:
                return new ReservationServiceIMPL();
            default:
                return null;
        }
    }

    private ServiceFactoryIMPL() throws RemoteException {}

    public static ServiceFactoryIMPL getInstance() throws RemoteException {
        return (null == serviceFactory) ? (serviceFactory = new ServiceFactoryIMPL()) : serviceFactory;
    }
}