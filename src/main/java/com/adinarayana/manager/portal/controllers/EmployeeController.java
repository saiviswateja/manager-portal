package com.adinarayana.manager.portal.controllers;

import com.adinarayana.manager.portal.models.Employee;
import com.adinarayana.manager.portal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public Employee postEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employeeService.retrieveEmployees();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/")
    public void putEmployee(@RequestBody Employee employee) throws Exception {
        employeeService.updateEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }
}
