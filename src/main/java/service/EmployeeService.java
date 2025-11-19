package service;

import javafx.collections.ObservableList;
import model.Employee;

import java.sql.SQLException;

public interface EmployeeService {
//     ObservableList<Employee>getAllEmployeeDetails();
     void add(Employee employee) throws SQLException;
}
