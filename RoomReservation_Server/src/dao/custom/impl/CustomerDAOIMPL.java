package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entities.CustomerEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOIMPL implements CustomerDAO {

    private Connection connection;

    @Override
    public boolean add(CustomerEntity entity) throws SQLException {
        return CrudUtil.execute("INSERT INTO Customers(NIC,Name,Contact,Address) VALUES(?, ?, ?,?)", connection, entity.getNic(),entity.getCustomerName(), entity.getContactNumber(), entity.getAddress());
    }

    @Override
    public boolean update(CustomerEntity entity) throws SQLException {
        return CrudUtil.execute("UPDATE Customers SET Name = ?, Contact = ?, Address = ? WHERE NIC = ?", connection, entity.getCustomerName(), entity.getContactNumber(), entity.getAddress(), entity.getNic());
    }

    @Override
    public boolean delete(CustomerEntity entity) throws SQLException {
        return CrudUtil.execute("DELETE FROM Customers WHERE NIC = ?", connection, entity.getNic());
    }

    @Override
    public CustomerEntity search(CustomerEntity entity) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customers WHERE NIC = ?", connection, entity.getNic());
        while (rst.next()){
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setNic(rst.getString("NIC"));
            customerEntity.setCustomerName(rst.getString("Name"));
            customerEntity.setContactNumber(rst.getInt("Contact"));
            customerEntity.setAddress(rst.getString("Address"));
            return customerEntity;
        }
        return null;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customers", connection);
        ArrayList<CustomerEntity> allEntitiies = new ArrayList<>();
        while (rst.next()){
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setNic(rst.getString("NIC"));
            customerEntity.setCustomerName(rst.getString("Name"));
            customerEntity.setContactNumber(rst.getInt("Contact"));
            customerEntity.setAddress(rst.getString("Address"));
            allEntitiies.add(customerEntity);
        }
        return allEntitiies;
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public ArrayList<CustomerEntity> searchAll(String cus) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customers WHERE NIC like ? || Name like ? || Contact like ? || Address like ?", connection, cus, cus, cus, cus);
        ArrayList<CustomerEntity> allEntitiies = new ArrayList<>();
        while (rst.next()){
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setNic(rst.getString("NIC"));
            customerEntity.setCustomerName(rst.getString("Name"));
            customerEntity.setContactNumber(rst.getInt("Contact"));
            customerEntity.setAddress(rst.getString("Address"));
            allEntitiies.add(customerEntity);
        }
        return allEntitiies;
    }
}