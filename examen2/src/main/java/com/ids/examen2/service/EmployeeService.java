package com.ids.examen2.service;

import com.ids.examen2.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long employeeId);

    void deleteEmployee(long id);
}
