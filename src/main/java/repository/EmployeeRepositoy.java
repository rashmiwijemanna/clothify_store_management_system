package repository;

import model.Employee;

import java.sql.SQLException;

public interface EmployeeRepositoy {
    void add(Employee employee) throws SQLException;
}
