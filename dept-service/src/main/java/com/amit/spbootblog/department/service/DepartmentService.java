package com.amit.spbootblog.department.service;

import com.amit.spbootblog.department.VO.EmployeeVO;
import com.amit.spbootblog.department.VO.ResponseVO;
import com.amit.spbootblog.department.entity.Department;
import com.amit.spbootblog.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository deptRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Department saveDepartent(Department dept) {
        log.info("Entered method saveDepartent of  DepartmentService");
        return deptRepo.save(dept);
    }

    public Department getDepartmentById(Long deptId) {
        log.info("Entered method getDepartmentById of  DepartmentService");
        return deptRepo.findByDepartmentId(deptId);
    }

    public ResponseVO getDepartmentWithEmployee(Long deptId) {
        log.info("Entered method getDepartmentWithEmployee of  DepartmentService");
        ResponseVO returnObj = new ResponseVO();
        System.out.println("deptId : "+deptId);
        Department dept = deptRepo.findByDepartmentId(deptId);
        System.out.println("Name : "+dept.getDepartmentName());
        ResponseEntity<EmployeeVO[]> response =
                 restTemplate.getForEntity("http://EMPLOYEE-SERVICE/employee/findByDept/" + dept.getDepartmentId(),
                         EmployeeVO[].class);
        EmployeeVO[] empList = response.getBody();
        returnObj.setDepartment(dept);
        returnObj.setEmployeeList(Arrays.asList(empList));
        return returnObj;
    }

    public List<Department> getAllDepartment() {
        log.info("Entered method getAllDepartment of  DepartmentService");
        return deptRepo.findAll();
    }
}
