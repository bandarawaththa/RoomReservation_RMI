package connector;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.ReservationService;
import service.custom.RoomService;
import service.custom.UserService;

import java.net.MalformedURLException;
import java.rmi.*;

public class ProxyHandler {
    private static ProxyHandler handler;
    private UserService userService;
    private CustomerService customerService;
    private RoomService roomService;
    private ReservationService reservationService;

    private ProxyHandler() {
        try {
            ServiceFactory lookup = (ServiceFactory) Naming.lookup("rmi://localhost:5050/RoomReserve");
            userService = (UserService) lookup.getService(ServiceFactory.ServiceTypes.USER);
            customerService = (CustomerService) lookup.getService(ServiceFactory.ServiceTypes.CUSTOMER);
            roomService = (RoomService) lookup.getService(ServiceFactory.ServiceTypes.ROOM);
            reservationService = (ReservationService) lookup.getService(ServiceFactory.ServiceTypes.RESERVATION);
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    public static ProxyHandler getInstance() {
        return (null == handler) ? (handler = new ProxyHandler()) : handler;
    }

    public UserService getUserService () {
        return userService;
    }

    public CustomerService getCustomerService () {
        return customerService;
    }

    public RoomService getRoomService () {
        return roomService;
    }

    public ReservationService getReservationService () {
        return reservationService;
    }
}