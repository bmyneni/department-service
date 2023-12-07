package com.vw.department.service;

import com.vw.department.entity.Department;

import java.util.List;

public interface IDepartmentService {
    // Save operation
    Department saveDepartment(Department department);

    // Read operation
    List<Department> fetchDepartmentList();

    // Update operation
    Department updateDepartment(Department department,
                                Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);


}
