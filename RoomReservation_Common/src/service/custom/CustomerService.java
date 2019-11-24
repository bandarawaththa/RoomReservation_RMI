package service.custom;

import dtos.CustomerDTO;
import service.SuperService;

import java.util.ArrayList;

public interface CustomerService extends SuperService {
    public boolean addCustomer(CustomerDTO cus)throws Exception;
    public boolean deleteCustomer(CustomerDTO cus)throws Exception;
    public CustomerDTO searchCustomer(CustomerDTO cus)throws Exception;
    public boolean updateCustomer(CustomerDTO cus)throws Exception;
    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;
    public ArrayList<CustomerDTO> searchAllCustomers(String cus)throws Exception;
}