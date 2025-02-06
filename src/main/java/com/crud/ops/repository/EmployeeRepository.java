package com.crud.ops.repository;

import com.crud.ops.model.Employee;
import com.crud.ops.response.ResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select new com.crud.ops.response.ResponseDto( emp.empName empName,dept.deptName deptName) from Employee emp inner join Department dept on emp.department.deptId=dept.deptId")
    List<ResponseDto> findEmpNameAndDeptNameList();
}
