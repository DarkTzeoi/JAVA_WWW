package iuh.fit.se.baitap1;

import iuh.fit.se.baitap1.dao.EmployeeDAO;
import iuh.fit.se.baitap1.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.baitap1.dao", "iuh.fit.se.baitap1.impl"})
public class BaiTap1Application {

    public static void main(String[] args) {
        SpringApplication.run(BaiTap1Application.class, args);

    }
    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO){
        return args -> {
            Employee employee = new Employee(1, "Pham Dac Thinh", "Leader");
            employeeDAO.save(employee);

            List<Employee> employees = employeeDAO.getAll();
            employees.forEach(System.out::println);

            Employee employee1 = employeeDAO.getById(1);
            System.out.println(employee1);

        };
    };

}
