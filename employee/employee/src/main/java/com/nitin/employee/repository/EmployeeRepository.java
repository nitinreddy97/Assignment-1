package com.nitin.employee.repository;

import com.nitin.employee.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
