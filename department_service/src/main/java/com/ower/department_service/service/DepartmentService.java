package com.ower.department_service.service;

import com.ower.department_service.entity.Department;
import com.ower.department_service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of Department service ");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside find department by id method of Department service");
        return departmentRepository.findById(departmentId).get();
    }
}
