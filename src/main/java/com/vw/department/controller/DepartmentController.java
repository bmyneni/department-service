package com.vw.department.controller;

import com.vw.department.entity.Department;
import com.vw.department.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {
    @Autowired
    private IDepartmentService iDepartmentService;

    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department)
    {
        return iDepartmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return iDepartmentService.fetchDepartmentList();
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department,
                                       @PathVariable("id") Long departmentId)
    {
        return iDepartmentService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        iDepartmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
