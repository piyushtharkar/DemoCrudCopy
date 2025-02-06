package com.crud.ops.service.impl;

import com.crud.ops.model.Department;
import com.crud.ops.model.Employee;
import com.crud.ops.repository.DepartmentRepository;
import com.crud.ops.repository.EmployeeRepository;
import com.crud.ops.request.EmployeeDto;
import com.crud.ops.response.ResponseDto;
import com.crud.ops.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CrudServiceImpl implements CrudService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository  departmentRepository;

    @Override
    public String createEmployee(EmployeeDto employeeDto) {
        Department department=departmentRepository.findById(employeeDto.getDeptId()).orElse(null);

        Employee employee=new Employee();
        employee.setEmpName(employeeDto.getEmpName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setDepartment(department);
        if(employeeRepository.save(employee)!=null){
            return "employee saved successfully";
        }
        return "unsuccessfull" ;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return  employeeRepository.findAll();
    }

    @Override
    public String updateEmployeeById(Integer empId,EmployeeDto employeeDto) {
        Employee emp=employeeRepository.findById(empId).orElseThrow(()->new RuntimeException("not found"));

        emp.setSalary(employeeDto.getSalary());
        emp.setEmail(employeeDto.getEmail());
        emp.setEmpName(employeeDto.getEmpName());
        emp.setDepartment(departmentRepository.findById(employeeDto.getDeptId()).orElse(null));
        emp=employeeRepository.save(emp);
        if(emp!=null){
          return  "employee updated successfully";

        }
        return "employee updation failed";
    }

    @Override
    public String deleteEmployeeById(Integer empId) {
      employeeRepository.deleteById(empId);

        return "employee deleted successfully";
    }

    @Override
    public List<ResponseDto> getEmpNameAndDeptNameList() {
        return employeeRepository.findEmpNameAndDeptNameList();
    }

}
