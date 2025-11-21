package repository;

import db.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository{
    @Override
    public void add(Customer customer) throws SQLException {
        String sql="INSERT INTO Customer(CustId, CustTitle, CustName, DOB, PhoneNumber, Email, CustAddress, City) VALUES (?,?,?,?,?,?,?,?);";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,customer.getId());
        preparedStatement.setObject(2,customer.getTitle());
        preparedStatement.setObject(3,customer.getName());
        preparedStatement.setObject(4,customer.getDOB());
        preparedStatement.setObject(5,customer.getPhoneNumber());
        preparedStatement.setObject(6,customer.getEmail());
        preparedStatement.setObject(7,customer.getAddress());
        preparedStatement.setObject(8,customer.getCity());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public ResultSet getAllCustomerDetails() throws SQLException {

        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public String getLastCustId() {
        return "";
    }
}
