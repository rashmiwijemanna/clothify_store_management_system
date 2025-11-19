package repository;

import javafx.collections.ObservableList;
import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeRepositoy {
    void add(Employee employee) throws SQLException;
    ResultSet getAllEmployeeDetails() throws SQLException;
    String getLastEmployeeId() throws SQLException;
    void delete(String id) ;
}
