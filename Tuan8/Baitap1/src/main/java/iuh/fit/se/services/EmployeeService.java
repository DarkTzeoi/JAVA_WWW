package iuh.fit.se.services;

import iuh.fit.se.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> findALl();
    void delete(Employee employee);
    Employee findById(int id);
}
