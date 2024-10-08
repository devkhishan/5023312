package com.devkhishan.EmployeeManagementSystem.repository;

import com.devkhishan.EmployeeManagementSystem.model.Employee;
import com.devkhishan.EmployeeManagementSystem.projections.EmployeeProjection;
import com.devkhishan.EmployeeManagementSystem.projections.EmployeeProjectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    Employee findByName(@Param("name") String name);

    @Query(name = "Employee.findByEmail")
    Employee findByEmail(@Param("email") String email);
    List<Employee> findByDepartmentId(Long departmentId);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    Page<Employee> findAll(Pageable pageable);


    @Query("SELECT new com.devkhishan.EmployeeManagementSystem.projections.EmployeeProjectionClass(e.id, e.name) FROM Employee e")
    List<EmployeeProjectionClass> findEmployeeProjections();
}
