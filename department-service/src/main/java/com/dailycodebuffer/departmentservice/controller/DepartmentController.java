package com.dailycodebuffer.departmentservice.controller;

import com.dailycodebuffer.departmentservice.client.EmployeeClient;
import com.dailycodebuffer.departmentservice.model.Department;
import com.dailycodebuffer.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Autowired
    private final EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        logger.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        logger.info("Find the Department");
        return departmentRepository.findAll();
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        logger.info("Find the Department");
        List<Department> departments = departmentRepository.findAll();

        departments.forEach(department ->
                department.setEmployees(
                       employeeClient.getDepartments(department.getId())));

        return departments;
    }

    @GetMapping(path ="/{id}")
    public Department getById(@PathVariable("id") Long id) {
        logger.info("Department find: id={}", id);
       return departmentRepository.findById(id);
    }

}
