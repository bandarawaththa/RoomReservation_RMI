package service.custom;

import dtos.CustomDTO;
import service.SuperService;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ReservationService extends SuperService {
    public boolean addReservation (CustomDTO reservation) throws RemoteException, SQLException;
}
