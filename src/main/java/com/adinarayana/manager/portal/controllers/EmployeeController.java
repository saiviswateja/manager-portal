package com.adinarayana.manager.portal.controllers;

import com.adinarayana.manager.portal.models.Employee;
import com.adinarayana.manager.portal.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public Employee postEmployee(@Valid @RequestBody Employee employee) {
        log.trace("Request to add employee with details " + employee.toString());
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> getEmployees() {
        log.trace("Request to get list employees");
        return employeeService.retrieveEmployees();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/")
    public void putEmployee(@RequestBody Employee employee) throws Exception {
        log.trace("Request to update employee with details " + employee.toString());
        employeeService.updateEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public void deleteEmployee(@RequestBody Employee employee) {
        log.trace("Request to delete employee with details " + employee.toString());
        employeeService.deleteEmployee(employee);
    }
}
