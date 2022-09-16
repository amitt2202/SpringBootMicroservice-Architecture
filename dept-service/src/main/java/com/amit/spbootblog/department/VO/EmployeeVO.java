package com.amit.spbootblog.department.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}
