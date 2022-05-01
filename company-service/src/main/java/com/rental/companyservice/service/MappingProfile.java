package com.rental.companyservice.service;

import com.rental.companyservice.entity.Company;
import com.rental.companyservice.entity.Employee;
import com.rental.companyservice.service.company.CompanyDTO;
import com.rental.companyservice.service.employee.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingProfile {
    private ModelMapper mapper;
    MappingProfile(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CompanyDTO map(Company company) {
        return mapper.map(company, CompanyDTO.class);
    }

    public EmployeeDTO map(Employee employee) {
        return mapper.map(employee, EmployeeDTO.class);
    }
}
