package service.impl;

import business.BOFactory;
import business.custom.ReservationBO;
import dtos.CustomDTO;
import service.custom.ReservationService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ReservationServiceIMPL extends UnicastRemoteObject implements ReservationService {
    private ReservationBO bo = (ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RESERVATION);

    public ReservationServiceIMPL() throws RemoteException {}

    @Override
    public boolean addReservation(CustomDTO reservation) throws RemoteException, SQLException {
        return bo.addReservation(reservation);
    }
}
