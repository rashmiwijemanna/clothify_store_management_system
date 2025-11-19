package service;

import javafx.collections.ObservableList;
import model.Employee;

import java.sql.SQLException;

public interface EmployeeService {
     ObservableList<Employee>getAllEmployeeDetails() throws SQLException;
     void add(Employee employee) throws SQLException;
     void delete(String id) ;
     String generateEmployeeId() throws SQLException;
     void update(Employee employee) throws SQLException;
}
