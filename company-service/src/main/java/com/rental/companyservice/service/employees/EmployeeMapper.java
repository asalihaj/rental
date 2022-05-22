package com.rental.companyservice.service.employees;

import com.rental.companyservice.entity.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {
    private final ModelMapper mapper;

    EmployeeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public List<EmployeeDto> map(List<Employee> employees) {
        List<EmployeeDto> _employees = new ArrayList<>();
        TypeMap<Employee, EmployeeDto> typeMap = mapper.createTypeMap(Employee.class, EmployeeDto.class);
        typeMap.addMapping(Employee::getCompany, EmployeeDto::setCompany);
        typeMap.addMapping(Employee::getLocation, EmployeeDto::setLocation);
        for(Employee employee : employees) {
            _employees.add(mapper.map(employee, EmployeeDto.class));
        }
        return _employees;
    }

}
