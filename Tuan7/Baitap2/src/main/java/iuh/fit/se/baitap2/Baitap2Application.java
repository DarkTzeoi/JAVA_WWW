package iuh.fit.se.baitap2;

import iuh.fit.se.baitap2.dao.DepartmentDAO;
import iuh.fit.se.baitap2.dao.EmployeeDAO;
import iuh.fit.se.baitap2.entity.Department;
import iuh.fit.se.baitap2.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class Baitap2Application {

    public static void main(String[] args) {
        SpringApplication.run(Baitap2Application.class, args);
    }
    @Bean
    CommandLineRunner deptRunner(DepartmentDAO departmentService){
        return args -> {
            if(departmentService.findDepartmentByDeptName("IT") == null){
                Department itDept = new Department();
                itDept.setDeptName("IT");
                departmentService.save(itDept);
            }
            if (departmentService.findDepartmentByDeptName("TEST") == null){
                Department testDept = new Department();
                testDept.setDeptName("TEST");
                departmentService.save(testDept);
            }
        };
    }
    @Bean
    CommandLineRunner empRunner(EmployeeDAO employeeService, DepartmentDAO departmentService){
        return args -> {
            Department dept = departmentService.findDepartmentByDeptName("IT");
            Employee employee = new Employee();
            employee.setEmpName("Thinh");
            employee.setDob(Date.valueOf("2004-01-23"));
            employee.setDept(dept);
            employeeService.save(employee);
        };
    }

}
