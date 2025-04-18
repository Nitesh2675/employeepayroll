package com.brigelabz.employeepayrollapp.controller;

import com.brigelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.brigelabz.employeepayrollapp.dto.ResponseDTO;
import com.brigelabz.employeepayrollapp.model.EmployeePayrollData;
import com.brigelabz.employeepayrollapp.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * Get all employees
     */
    @GetMapping({"", "/"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get all employees successful", empList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    /**
     * Get employee by ID
     */
    @GetMapping("/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = (empData != null)
                ? new ResponseDTO("Get employee by ID successful", empData)
                : new ResponseDTO("Employee with ID " + empId + " not found", null);
        HttpStatus status = (empData != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(respDTO, status);
    }

    /**
     * Get employees by department
     */
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeesByDepartment(@PathVariable("department") String department) {
        List<EmployeePayrollData> empList = employeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO("Get employees by department successful", empList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    /**
     * Create a new employee record
     */
    @PostMapping({"", "/"})
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(
            @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Employee created successfully", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.CREATED);
    }

    /**
     * Update an existing employee record
     */
    @PutMapping("/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable("empId") int empId,
            @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = (empData != null)
                ? new ResponseDTO("Employee updated successfully", empData)
                : new ResponseDTO("Employee with ID " + empId + " not found", null);
        HttpStatus status = (empData != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(respDTO, status);
    }

    /**
     * Delete an employee record
     */
    @DeleteMapping("/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(empId);
        if (empData == null) {
            ResponseDTO respDTO = new ResponseDTO("Employee with ID " + empId + " not found", null);
            return new ResponseEntity<>(respDTO, HttpStatus.NOT_FOUND);
        }
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Employee deleted successfully", null);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}
