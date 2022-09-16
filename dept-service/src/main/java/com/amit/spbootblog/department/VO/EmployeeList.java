package com.amit.spbootblog.department.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class EmployeeList {
    private List<EmployeeVO> employees;

    public EmployeeList() {
        employees = new ArrayList<>();
    }
}
