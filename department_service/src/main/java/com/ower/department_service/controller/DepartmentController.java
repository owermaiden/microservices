package com.ower.department_service.controller;

import com.ower.department_service.entity.Department;
import com.ower.department_service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside save department method of Departmentcontroller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDeaprtmentById method of Department Controller");
        return departmentService.findDepartmentById(departmentId);
    }


}
