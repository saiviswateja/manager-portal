package com.adinarayana.manager.portal.services;

import com.adinarayana.manager.portal.models.Employee;
import com.adinarayana.manager.portal.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        log.trace("In Employee Service, for adding employee "+ employee.toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> retrieveEmployees() {
        log.trace("In Employee Service, for retrieving all employees");
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) throws Exception {
        log.trace("In Employee Service, for updating the employee with details "+ employee.toString());
        Optional<Employee> employee1 = employeeRepository.findById(employee.getEmployeePk());
        if(!employee1.isPresent()) {
            throw new Exception("User Not Found");
        }
        Employee updateEmployeeDetails = employee1.get();
        updateEmployeeDetails.setFirstName(employee.getFirstName());
        updateEmployeeDetails.setLastName(employee.getLastName());
        updateEmployeeDetails.setAddress(employee.getAddress());
        updateEmployeeDetails.setCompanyName(employee.getCompanyName());
        updateEmployeeDetails.setBirthDate(employee.getBirthDate());
        return employeeRepository.save(updateEmployeeDetails);
    }

    public void deleteEmployee(Employee employee) {
        log.trace("In Employee Service, for deleting the employee with details "+ employee.toString());
        employeeRepository.deleteById(employee.getEmployeePk());
    }
}
