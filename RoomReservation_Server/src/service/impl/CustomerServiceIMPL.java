package service.impl;

import business.BOFactory;
import business.custom.CustomerBO;
import dtos.CustomerDTO;
import service.custom.CustomerService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CustomerServiceIMPL extends UnicastRemoteObject implements CustomerService {
    private CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    public CustomerServiceIMPL() throws RemoteException {}

    @Override
    public boolean addCustomer(CustomerDTO cus) throws Exception {
        return bo.addCustomer(cus);
    }

    @Override
    public boolean deleteCustomer(CustomerDTO cus) throws Exception {
        return bo.deleteCustomer(cus);
    }

    @Override
    public CustomerDTO searchCustomer(CustomerDTO cus) throws Exception {
        return bo.searchCustomer(cus);
    }

    @Override
    public boolean updateCustomer(CustomerDTO cus) throws Exception {
        return bo.updateCustomer(cus);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        return bo.getAllCustomers();
    }

    @Override
    public ArrayList<CustomerDTO> searchAllCustomers(String cus) throws Exception {
        return bo.searchAllCustomers("%" + cus + "%");
    }
}