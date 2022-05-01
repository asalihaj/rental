package com.rental.companyservice.service.employee;

import com.rental.companyservice.entity.Company;
import com.rental.companyservice.entity.Employee;
import com.rental.companyservice.repository.CompanyRepository;
import com.rental.companyservice.repository.EmployeeRepository;
import com.rental.companyservice.service.MappingProfile;
import com.rental.companyservice.service.company.CompanyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EmployeeService {
    private EmployeeRepository repository;
    private CompanyRepository companyRepository;
    private MappingProfile mapper;
    EmployeeService(
            EmployeeRepository repository,
            MappingProfile mapper,
            CompanyRepository companyRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<List<EmployeeDTO>> list() {
        try {
            List<EmployeeDTO> employees = new ArrayList<>();
            List<Employee> employeeModel = repository.findAll();

            for (Employee employee : employeeModel) {
                employees.add(mapper.map(employee));
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<EmployeeDTO> get(String username) {
        try {
            Optional<Employee> employee = repository.findById(username);
            if (employee.isPresent()) {
                EmployeeDTO _employee = mapper.map(employee.get());
                return  new ResponseEntity<>(_employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<EmployeeDTO> create(Employee employee) {
        //TODO: Implemet create function
        return null;
    }

    public ResponseEntity<EmployeeDTO> edit(String username, Employee employee) {
        Optional<Employee> employeeData = repository.findById(username);
        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setUsername(employee.getUsername());
            _employee.setEmail(employee.getEmail());
            _employee.setPassword(employee.getPassword());

            EmployeeDTO employeeToReturn = mapper.map(repository.save(_employee));
            return new ResponseEntity<>(employeeToReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> delete(String username) {
        try {
            repository.deleteById(username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
