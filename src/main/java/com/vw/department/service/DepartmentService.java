package com.vw.department.service;

import com.vw.department.entity.Department;
import com.vw.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService

{
    @Autowired
    private DepartmentRepository departmentRepository;
    //Save operation
    public Department saveDepartment(Department dept){
        return departmentRepository.save(dept);
    }

    //Read operation
    public List<Department> fetchDepartmentList() {
        return (List<Department>)
                departmentRepository.findAll();
    }

    //Update operation
    public Department updateDepartment(Department department, Long departmentId) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depDB);
    }

    //Delete operation
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }
}
