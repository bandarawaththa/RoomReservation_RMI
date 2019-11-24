package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dbHandler.DBCon;
import dtos.CustomerDTO;
import entities.CustomerEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class CustomerBOIMPL implements CustomerBO {
    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO cus) throws Exception {
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

    @Override
    public boolean deleteCustomer(CustomerDTO cus) throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()) {
            dao.setConnection(connection);
            CustomerEntity entity = new CustomerEntity();
            entity.setNic(cus.getNic());
            return dao.delete(entity);
        }
    }

    @Override
    public CustomerDTO searchCustomer(CustomerDTO cus) throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()) {
            dao.setConnection(connection);
            CustomerEntity temp = new CustomerEntity();
            temp.setNic(cus.getNic());
            CustomerEntity entity = dao.search(temp);
            return (null != entity) ? new CustomerDTO(entity.getNic(), entity.getCustomerName(), entity.getContactNumber(), entity.getAddress()) : null;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO cus) throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()) {
            dao.setConnection(connection);
            CustomerEntity entity = new CustomerEntity();
            entity.setNic(cus.getNic());
            entity.setCustomerName(cus.getCustomerName());
            entity.setContactNumber(cus.getContact());
            entity.setAddress(cus.getAddress());
            return dao.update(entity);
        }
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()){
            dao.setConnection(connection);
            ArrayList<CustomerEntity> allEntities = dao.getAll();
            ArrayList<CustomerDTO> allDTOS = new ArrayList<>();
            for (CustomerEntity entity :
                    allEntities) {
                allDTOS.add(new CustomerDTO(entity.getNic(), entity.getCustomerName(), entity.getContactNumber(), entity.getAddress()));
            }
            return allDTOS;
        }
    }

    @Override
    public ArrayList<CustomerDTO> searchAllCustomers(String cus) throws Exception {
        try (Connection connection = DBCon.getInstance().getConnection()){
            dao.setConnection(connection);
            ArrayList<CustomerEntity> allEntities = dao.searchAll(cus);
            ArrayList<CustomerDTO> allDTOS = new ArrayList<>();
            for (CustomerEntity entity :
                    allEntities) {
                allDTOS.add(new CustomerDTO(entity.getNic(), entity.getCustomerName(), entity.getContactNumber(), entity.getAddress()));
            }
            return allDTOS;
        }
    }
}