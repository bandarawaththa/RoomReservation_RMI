package serverStart;

import service.ServiceFactoryIMPL;
import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("RoomReserve", ServiceFactoryIMPL.getInstance());
            System.out.println("\n\nS\tt\ta\tr\tt\ti\tn\tg\n\t\t\t\t\t\t\t\tS\te\tr\tv\te\tr\t ... !");
        } catch (AccessException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}