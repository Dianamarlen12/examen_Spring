package com.ids.examen2.controller;

import com.ids.examen2.exception.Mensaje;
import com.ids.examen2.model.Employee;
import com.ids.examen2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/lista")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> lista = employeeService.getAllEmployees();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin employee en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/detalles/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.employeeService.getEmployeeById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/eliminar/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id){
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }
}
