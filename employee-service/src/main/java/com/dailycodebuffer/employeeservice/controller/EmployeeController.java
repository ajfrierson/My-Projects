package com.dailycodebuffer.employeeservice.controller;

import com.dailycodebuffer.employeeservice.model.Employee;
import com.dailycodebuffer.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        logger.info("Employee add: {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        logger.info("Find all employees");
        return employeeRepository.findAll();
    }

    @GetMapping(path ="/{id}")
    public Employee getById(@PathVariable("id") Long id) {
        logger.info("Employee find: id={}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping(path="/department/{departmentId}")
    public List<Employee> getDepartments(@PathVariable("departmentId") Long departmentId) {
        return employeeRepository.findByDepartment(departmentId);
    }
}
