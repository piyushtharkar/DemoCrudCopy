package com.crud.ops.service;

import com.crud.ops.model.Employee;
import com.crud.ops.request.EmployeeDto;
import com.crud.ops.response.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService {

    String createEmployee(EmployeeDto employeeDto);


    List<Employee> getEmployeeList();

    String updateEmployeeById(Integer empId,EmployeeDto employeeDto);

    String deleteEmployeeById(Integer empId);

    List<ResponseDto> getEmpNameAndDeptNameList();
}
