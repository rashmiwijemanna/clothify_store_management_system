package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService{
    CustomerRepositoryImpl customerRepositoryImpl=new CustomerRepositoryImpl();
    ObservableList<Customer>customer= FXCollections.observableArrayList();

    @Override
    public void add(Customer customer) throws SQLException {
        customerRepositoryImpl.add(customer);


    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public String generateCustId() {
        return "";
    }

    @Override
    public ObservableList<Customer> getAllCustDetails() {
        return null;
    }
}
