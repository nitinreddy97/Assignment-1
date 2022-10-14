package com.nitin.employee.controller;

import com.nitin.employee.exception.DepartmentNotfoundException;
import com.nitin.employee.modal.Department;
import com.nitin.employee.modal.Employee;
import com.nitin.employee.repository.DepartmentRepository;
import com.nitin.employee.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

    private static Map<Long, Department> departmentRepo = new HashMap<>();
    static {
        Department department = new Department();
        department.setDepartmentId(1);
        department.setDepartmentName("dev");
        department.setDepartmentNumber(111);
        departmentRepo.put(department.getDepartmentId(), department);

        department = new Department();
        department.setDepartmentId(2);
        department.setDepartmentName("test");
        department.setDepartmentNumber(222);
        departmentRepo.put(department.getDepartmentId(), department);

        department = new Department();
        department.setDepartmentId(3);
        department.setDepartmentName("QA");
        department.setDepartmentNumber(333);
        departmentRepo.put(department.getDepartmentId(), department);

        department = new Department();
        department.setDepartmentId(4);
        department.setDepartmentName("prod");
        department.setDepartmentNumber(444);
        departmentRepo.put(department.getDepartmentId(), department);
    }

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    @PostMapping("addNewEmployee")
    public  String newEmployee(Employee employee){
        employeeRepository.save(employee);
        return "";
    }

    @DeleteMapping("deleteDepartment/{departmentId}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable @Valid long departmentId){
        if(!departmentRepo.containsKey(departmentId))throw new DepartmentNotfoundException(departmentId+" department ID not found");
        departmentRepo.remove(departmentId);
        //departmentRepository.deleteById(departmentId);
        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }

}
