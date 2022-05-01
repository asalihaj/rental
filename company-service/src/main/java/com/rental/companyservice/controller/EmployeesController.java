package com.rental.companyservice.controller;

import com.rental.companyservice.entity.Company;
import com.rental.companyservice.entity.Employee;
import com.rental.companyservice.service.employee.EmployeeDTO;
import com.rental.companyservice.service.employee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    private EmployeeService service;

    EmployeesController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> list() {
        return service.list();
    }

    @GetMapping("/{username}")
    public ResponseEntity<EmployeeDTO> get(@PathVariable("username") String username) {
        return service.get(username);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @PutMapping("/{username}")
    public ResponseEntity<EmployeeDTO> edit(@PathVariable("username") String username, @RequestBody Employee employee) {
        return service.edit(username, employee);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("username") String username) {
        return service.delete(username);
    }
}
