package com.ids.examen2.service;

import com.ids.examen2.exception.ResourceNotFoundException;
import com.ids.examen2.model.Employee;
import com.ids.examen2.model.Language;
import com.ids.examen2.repository.EmployeeRepository;
import com.ids.examen2.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getIdEmployee());

        if (employeeDb.isPresent()){
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setIdEmployee(employee.getIdEmployee());
            employeeUpdate.setSurname(employee.getSurname());
            employeeUpdate.setFirstname(employee.getFirstname());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + employee.getIdEmployee());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employeeId);

        if (employeeDB.isPresent()) {
            return employeeDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employeeId);
        }
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employeeId);

        if (employeeDB.isPresent()) {
            this.employeeRepository.delete(employeeDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + employeeId);
        }
    }
}