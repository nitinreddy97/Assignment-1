package com.nitin.employee.repository;

import com.nitin.employee.modal.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
