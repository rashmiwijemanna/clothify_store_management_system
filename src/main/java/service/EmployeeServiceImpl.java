package service;

import javafx.collections.ObservableList;
import model.Employee;
import repository.EmployeeRepositoryImpl;

import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepositoryImpl employeeRepositoryImpl=new EmployeeRepositoryImpl();
//    @Override
//    public ObservableList<Employee> getAllEmployeeDetails() {
//
//    }

    @Override
    public void add(Employee employee) throws SQLException {
        employeeRepositoryImpl.add(employee);

    }
}
