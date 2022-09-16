package com.amit.spbootblog.employee.service;

import com.amit.spbootblog.employee.VO.Department;
import com.amit.spbootblog.employee.VO.ResponseTemplateVO;
import com.amit.spbootblog.employee.entity.Employee;
import com.amit.spbootblog.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Employee saveEmployee(Employee employee) {
        log.info("Entered method saveEmployee of EmployeeService");
        return employeeRepository.save(employee);
    }

    public ResponseTemplateVO getEmployeeWithDept(Long employeeId) {
        log.info("Entered method getEmployeeWithDept of EmployeeService");
        ResponseTemplateVO response = new ResponseTemplateVO();
        Employee emp = employeeRepository.findByEmployeeId(employeeId);
        System.out.println("emp "+emp.getDepartmentId());
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + emp.getDepartmentId(),
                        Department.class);
        response.setEmployee(emp);
        response.setDepartment(department);
        return response;
    }


    public List<Employee> getAllEmployeeByDept(Long deptId) {
        log.info("Entered method getAllEmployeeByDept of EmployeeService");
        return employeeRepository.findByDepartmentId(deptId);
    }
}
