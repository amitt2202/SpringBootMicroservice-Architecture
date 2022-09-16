
package com.amit.spbootblog.department.controller;

import com.amit.spbootblog.department.VO.ResponseVO;
import com.amit.spbootblog.department.entity.Department;
import com.amit.spbootblog.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService deptService;

    @PostMapping("/")
    public Department saveDepartent(@RequestBody Department dept){
        log.info("Entered method saveDepartent of  DepartmentController");
        return deptService.saveDepartent(dept);
    }
    @GetMapping("/allDepartment")
    public List<Department> getAllDepartment(){
        log.info("Entered method getAllDepartment of  DepartmentController");
        return deptService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long deptId){
        log.info("Entered method getDepartmentById of  DepartmentController");
        return deptService.getDepartmentById(deptId);

    }
    @GetMapping("/fullDetails/{id}")
    public ResponseVO getDepartmentWithEmployee(@PathVariable("id") Long deptId){
        log.info("Entered method getDepartmentWithEmployee of  DepartmentController");
        return deptService.getDepartmentWithEmployee(deptId);

    }
}
