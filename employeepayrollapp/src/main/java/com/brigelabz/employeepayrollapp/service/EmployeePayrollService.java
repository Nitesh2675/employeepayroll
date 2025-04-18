package com.brigelabz.employeepayrollapp.service;

import com.brigelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.brigelabz.employeepayrollapp.model.EmployeePayrollData;
import com.brigelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).orElse(null);
    }


    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("emp data: {}", empData.toString());

        return employeeRepository.save(empData);
    }


    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeeRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empID) {
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empID);
     employeeRepository.delete(empData);

    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }
}
