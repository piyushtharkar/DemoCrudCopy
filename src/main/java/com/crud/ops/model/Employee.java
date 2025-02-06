package com.crud.ops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
//    emp_id INT AUTO_INCREMENT PRIMARY KEY,
//    emp_name VARCHAR(100) NOT NULL,
//    email VARCHAR(100) UNIQUE NOT NULL,
//    salary DECIMAL(10,2) NOT NULL,
//    dept_id INT,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

}
