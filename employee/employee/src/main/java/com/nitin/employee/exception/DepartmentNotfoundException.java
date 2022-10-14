package com.nitin.employee.exception;

public class DepartmentNotfoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DepartmentNotfoundException(String message) {
        super(message);
    }
}
