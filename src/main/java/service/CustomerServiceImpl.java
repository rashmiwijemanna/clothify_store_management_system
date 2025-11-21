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
    public void delete(String id) throws SQLException {
        customerRepositoryImpl.delete(id);

    }

    @Override
    public void update(Customer customer) throws SQLException {
        customerRepositoryImpl.update(customer);

    }

    @Override
    public String generateCustId() throws SQLException {
        String lastCustId = customerRepositoryImpl.getLastCustId();
        if(lastCustId == null){
            return "C001";
        }
        int number=Integer.parseInt(lastCustId.substring(1));
        number++;
        return String.format("C%03d",number);
    }

    @Override
    public ObservableList<Customer> getAllCustDetails() throws SQLException {
        ResultSet allCustomerDetails = customerRepositoryImpl.getAllCustomerDetails();
        customer.clear();
        while (allCustomerDetails.next()){
            java.sql.Date sqlDate=allCustomerDetails.getDate("DOB");
            LocalDate dob= (sqlDate != null) ? sqlDate.toLocalDate() : null;
            customer.add(new Customer(
                    allCustomerDetails.getString("CustId"),
                    allCustomerDetails.getString("CustTitle"),
                    allCustomerDetails.getString("CustName"),
                    dob,
                    allCustomerDetails.getString("PhoneNumber"),
                    allCustomerDetails.getString("Email"),
                    allCustomerDetails.getString("CustAddress"),
                    allCustomerDetails.getString("City")
            ));
        }
        return customer;

    }

}
