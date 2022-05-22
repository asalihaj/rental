package com.rental.companyservice.service.employees;

import com.rental.companyservice.entity.Employee;
import com.rental.companyservice.repository.EmployeeRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    private final EmployeeRepo repository;
    private final EmployeeMapper mapper;

    EmployeeService(EmployeeRepo repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeDto> list() {
        try {
            List<Employee> employees = repository.findAll();
            return mapper.map(employees);
        } catch (Exception e) {
            throw e;
        }
    }

}
