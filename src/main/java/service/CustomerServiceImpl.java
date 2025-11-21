package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
    public ObservableList<Customer> getAllCustDetails() throws SQLException {
        ResultSet allCustomerDetails = customerRepositoryImpl.getAllCustomerDetails();
        customer.clear();
        while (allCustomerDetails.next()){
            customer.add(new Customer(
                    allCustomerDetails.getString("CustId"),
                    allCustomerDetails.getString("CustTitle"),
                    allCustomerDetails.getString("CustName"),
                    allCustomerDetails.getDate("DOB").toLocalDate(),
                    allCustomerDetails.getString("PhoneNumber"),
                    allCustomerDetails.getString("Email"),
                    allCustomerDetails.getString("CustAddress"),
                    allCustomerDetails.getString("City")
            ));
        }
        return customer;

    }
}
