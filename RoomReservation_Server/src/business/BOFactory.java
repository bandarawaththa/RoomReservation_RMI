package business;

import business.custom.impl.CustomerBOIMPL;
import business.custom.impl.ReservationBOIMPL;
import business.custom.impl.RoomBOIMPL;
import business.custom.impl.UserBOIMPL;

public class BOFactory {
    public static BOFactory boFactory;

    public BOFactory() {}

    public static BOFactory getInstance(){
        return (null == boFactory) ? (boFactory = new BOFactory()) : boFactory;
    }

    public enum BOTypes {
        USER, CUSTOMER, ROOM, RESERVATION;
    }

    public SuperBO getBO (BOTypes type){
        switch (type){
            case USER:
                return new UserBOIMPL();
            case CUSTOMER:
                return new CustomerBOIMPL();
            case ROOM:
                return new RoomBOIMPL();
            case RESERVATION:
                return new ReservationBOIMPL();
            default:
                return null;
        }
    }
}
