package com.brigelabz.employeepayrollapp.model;

import com.brigelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employee_payroll")
public @Data class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name="name")
    private String name;

    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns = @JoinColumn(name="id"))
    @Column(name="department")
    private List<String> departments;

    public EmployeePayrollData(){}

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO){
        this.employeeId=empId;
        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
        this.gender=employeePayrollDTO.gender;
        this.note=employeePayrollDTO.note;
        this.startDate= employeePayrollDTO.startDate;
        this.profilePic=employeePayrollDTO.profilePic;
        this.departments=employeePayrollDTO.department;
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        //this.employeeId=empId;
        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
        this.gender=employeePayrollDTO.gender;
        this.note=employeePayrollDTO.note;
        this.startDate= employeePayrollDTO.startDate;
        this.profilePic=employeePayrollDTO.profilePic;
        this.departments=employeePayrollDTO.department;
    }


    public void updateEmployeePayrollData(EmployeePayrollDTO dto) {
        this.name = dto.name;
        this.salary = dto.salary;
        this.gender = dto.gender;
        this.note = dto.note;
        this.startDate = dto.startDate;
        this.profilePic = dto.profilePic;
        this.departments = dto.department;
    }

}
