package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    public boolean add (T entity) throws SQLException;
    public boolean update(T entity) throws SQLException;
    public boolean delete(T entity) throws SQLException;
    public T search(T entity)throws SQLException;
    public ArrayList<T> getAll()throws SQLException;
}
