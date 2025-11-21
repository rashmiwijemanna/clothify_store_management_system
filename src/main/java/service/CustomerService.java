package service;

import javafx.collections.ObservableList;
import model.Customer;

import java.sql.SQLException;

public interface CustomerService {
    void add(Customer customer) throws SQLException;
    void delete(String id) throws SQLException;
    void update(Customer customer);
    String generateCustId();
    ObservableList<Customer>getAllCustDetails() throws SQLException;
}
