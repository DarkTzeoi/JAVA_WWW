package iuh.fit.se.services;

import iuh.fit.se.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> findALl();
    void deleteById(int id);
    Employee findById(int id);
    List<Employee> findByName(String name);


}
