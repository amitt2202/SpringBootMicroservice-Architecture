package com.amit.spbootblog.department.VO;


import com.amit.spbootblog.department.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
    private Department department;
    private List<EmployeeVO> employeeList;

}
