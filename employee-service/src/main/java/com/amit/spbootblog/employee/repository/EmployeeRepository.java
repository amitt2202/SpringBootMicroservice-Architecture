package com.amit.spbootblog.employee.repository;




import com.amit.spbootblog.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    Employee findByEmployeeId(Long empId);

    List<Employee> findByDepartmentId (Long departmentId);
}
