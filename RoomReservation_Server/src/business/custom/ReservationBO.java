package business.custom;

import business.SuperBO;
import dtos.CustomDTO;
import java.sql.SQLException;

public interface ReservationBO extends SuperBO {
    public boolean addReservation(CustomDTO reservation) throws SQLException;
}
