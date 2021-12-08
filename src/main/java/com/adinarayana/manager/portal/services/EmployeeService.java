package com.adinarayana.manager.portal.services;

import com.adinarayana.manager.portal.models.Employee;
import com.adinarayana.manager.portal.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) throws Exception {
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
        employeeRepository.deleteById(employee.getEmployeePk());
    }
}
