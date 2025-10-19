package iuh.fit.se.reposities;

import iuh.fit.se.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name, String name1);
}