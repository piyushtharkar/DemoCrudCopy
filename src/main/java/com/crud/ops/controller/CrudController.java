package com.crud.ops.controller;

import com.crud.ops.model.Employee;
import com.crud.ops.repository.EmployeeRepository;
import com.crud.ops.request.EmployeeDto;
import com.crud.ops.response.ResponseDto;
import com.crud.ops.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud-ops")
public class CrudController {

    @Autowired
    private CrudService crudService;



    @PostMapping("/create-employee")
    public String createEmployee(@RequestBody EmployeeDto employeeDto){

        return crudService.createEmployee(employeeDto);
    }

    @GetMapping("/get-employee-list")
    public List<Employee> getEmployeeList(){
        return crudService.getEmployeeList();
    }

    @PutMapping("/update-employee-by-id")
    public String updateEmployeeById(@RequestParam(name = "empId") Integer empId ,@RequestBody EmployeeDto employeeDto){

        return crudService.updateEmployeeById(empId,employeeDto);

    }

    @DeleteMapping("/delete-employee-by-id")
    public String deleteEmployeeById(@RequestParam(name = "empId") Integer empId){
        return crudService.deleteEmployeeById(empId);
    }

    @GetMapping("/get-emp-name-and-dept-name-list")
    public List<ResponseDto> getEmpNameAndDeptNameList(){
       return crudService.getEmpNameAndDeptNameList();
    }

}
