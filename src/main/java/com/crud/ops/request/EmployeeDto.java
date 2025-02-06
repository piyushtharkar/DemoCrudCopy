package com.crud.ops.request;

import com.crud.ops.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String empName;
    private String email;
    private Double salary;
    private Integer deptId;
}
