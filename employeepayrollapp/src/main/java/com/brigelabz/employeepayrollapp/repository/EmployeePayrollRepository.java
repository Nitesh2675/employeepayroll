package com.brigelabz.employeepayrollapp.repository;

import com.brigelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {

    @Query(value="select * from employee_payroll,employee_department=id and department=:department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);

}
