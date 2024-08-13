package com.devkhishan.EmployeeManagementSystem.repository;

import com.devkhishan.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    List<Employee> findByDepartmentId(Long departmentId);
}
