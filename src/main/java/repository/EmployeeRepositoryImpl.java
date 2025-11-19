package repository;

import db.DBConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRepositoryImpl implements EmployeeRepositoy {

    @Override
    public void add(Employee employee) throws SQLException {
        String SQL="INSERT INTO Employee(EmpId, EmpName, Email, Password, Address, PhoneNumber) VALUES(?,?,?,?,?,?);" ;
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(SQL);
        preparedStatement.setObject(1,employee.getId());
        preparedStatement.setObject(2,employee.getName());
        preparedStatement.setObject(3,employee.getEmail());
        preparedStatement.setObject(4,employee.getPassword());
        preparedStatement.setObject(5,employee.getAddress());
        preparedStatement.setObject(6,employee.getPhoneNumber());
        preparedStatement.executeUpdate();

    }
}
