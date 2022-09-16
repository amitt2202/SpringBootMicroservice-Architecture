package com.amit.spbootblog.employee.controller;

import com.amit.spbootblog.employee.VO.ResponseTemplateVO;
import com.amit.spbootblog.employee.entity.Employee;
import com.amit.spbootblog.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee emp){
        log.info("Entered method saveEmployee of EmployeeController");
        return employeeService.saveEmployee(emp);
    }
    @GetMapping("/{empId}")
    public ResponseTemplateVO getEmployeeWithDept(@PathVariable Long empId){
        log.info("Entered method getEmployeeWithDept of EmployeeController");
        return employeeService.getEmployeeWithDept(empId);
    }

    @GetMapping("/findByDept/{deptId}")
    public List<Employee> getAllEmployeeByDept(@PathVariable("deptId") Long deptId){
        log.info("Entered method getAllEmployeeByDept of EmployeeController");
        return employeeService.getAllEmployeeByDept(deptId);
    }
}
