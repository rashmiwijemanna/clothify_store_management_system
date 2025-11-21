package repository;

import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {
    void add(Customer customer) throws SQLException;
    void delete(String id) throws SQLException;
    void update(Customer customer);
    ResultSet getAllCustomerDetails() throws SQLException;
    String getLastCustId();
}
