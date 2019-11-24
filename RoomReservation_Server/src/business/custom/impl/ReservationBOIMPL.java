package business.custom.impl;

import business.custom.ReservationBO;
import dtos.CustomDTO;

import java.sql.SQLException;

public class ReservationBOIMPL implements ReservationBO {
    @Override
    public boolean addReservation(CustomDTO reservation) throws SQLException {
        try (Connection connection = DBCon.getInstance().getConnection()) {
            dao.setConnection(connection);
            CustomerEntity entity = new CustomerEntity();
            entity.setNic(cus.getNic());
            entity.setCustomerName(cus.getCustomerName());
            entity.setContactNumber(cus.getContact());
            entity.setAddress(cus.getAddress());
            return dao.add(entity);
        }
    }
}