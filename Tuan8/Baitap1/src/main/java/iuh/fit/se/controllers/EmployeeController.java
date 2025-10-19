package iuh.fit.se.controllers;

import iuh.fit.se.entity.Employee;
import iuh.fit.se.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping({"/employees", "/"})
    public String listEmployees(
            Model model,
            @RequestParam(value = "keyword", required = false) String keyword) {

        List<Employee> employees;

        if (keyword != null && !keyword.trim().isEmpty()) {
            employees = employeeService.findByName(keyword);
            model.addAttribute("keyword", keyword);
            System.out.println("Keyword nhận được: " + keyword);
            System.out.println("Số kết quả tìm kiếm: " + employees.size());
        } else {
            employees = employeeService.findALl();
        }

        model.addAttribute("employees", employees);
        return "listEmployee";
    }

    @GetMapping("/show-add-form")
    public String showAddForm(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("pageTitle", "REGISTRATION EMPLOYEE");
        model.addAttribute("formAction", "add");
        model.addAttribute("submitButtonText", "Register");
        return "addEmployee";
    }

    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/show-update-form")
    public String showUpdateForm(@RequestParam("id") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "UPDATE EMPLOYEE");
        model.addAttribute("formAction", "update");
        model.addAttribute("submitButtonText", "Update");
        return "addEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}