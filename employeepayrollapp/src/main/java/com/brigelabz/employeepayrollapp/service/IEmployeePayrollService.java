package com.brigelabz.employeepayrollapp.service;

import com.brigelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.brigelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empID);

    List<EmployeePayrollData> getEmployeesByDepartment(String department);
}
