package repository;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public ResultSet getAllEmployeeDetails() throws SQLException {
      Connection connection=DBConnection.getInstance().getConnection();
      PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM Employee;");
        ResultSet resultSet = preparedStatement.executeQuery();
        return  resultSet;

    }

    @Override
    public String getLastEmployeeId() throws SQLException {
        String sql="SELECT EmpId FROM Employee ORDER BY EmpId DESC LIMIT 1";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);

        }
        return null;
    }

    @Override
    public void delete(String id) {
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM Employee WHERE EmpId = ?");
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Employee employee) throws SQLException {
        String SQL="UPDATE Employee SET EmpName = ?, Email = ?, Password = ?, Address = ?, PhoneNumber = ? WHERE EmpId = ?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(SQL);
        preparedStatement.setObject(1,employee.getName());
        preparedStatement.setObject(2,employee.getEmail());
        preparedStatement.setObject(3,employee.getPassword());
        preparedStatement.setObject(4,employee.getAddress());
        preparedStatement.setObject(5,employee.getPhoneNumber());
        preparedStatement.setObject(6,employee.getId());
        preparedStatement.executeUpdate();
    }


}
