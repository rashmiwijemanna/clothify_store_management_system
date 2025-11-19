package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employee;
import repository.EmployeeRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepositoryImpl employeeRepositoryImpl=new EmployeeRepositoryImpl();
    ObservableList<Employee> employee= FXCollections.observableArrayList();

    @Override
    public ObservableList<Employee> getAllEmployeeDetails() throws SQLException {
        employee.clear();
        ResultSet allEmployeeDetails = employeeRepositoryImpl.getAllEmployeeDetails();
        while(allEmployeeDetails.next()){
            employee.add(new Employee(
               allEmployeeDetails.getString("EmpId"),
               allEmployeeDetails.getString("EmpName"),
               allEmployeeDetails.getString("Email"),
               allEmployeeDetails.getString("Password"),
               allEmployeeDetails.getString("Address"),
               allEmployeeDetails.getString("PhoneNumber")

            ));


        }

        return employee;

    }

    @Override
    public void add(Employee employee) throws SQLException {
        employeeRepositoryImpl.add(employee);

    }

    @Override
    public void delete(String id)  {
        employeeRepositoryImpl.delete(id);
    }

    @Override
    public String generateEmployeeId() throws SQLException {
        String lastId=employeeRepositoryImpl.getLastEmployeeId();
        if(lastId==null){
            return "E001";
        }
        int number=Integer.parseInt(lastId.substring(1));
        number++;

        return String.format("E%03d",number);
    }

    @Override
    public void update(Employee employee) throws SQLException {
        employeeRepositoryImpl.update(employee);
    }
}
