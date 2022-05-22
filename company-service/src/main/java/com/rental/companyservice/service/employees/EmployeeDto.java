package com.rental.companyservice.service.employees;

import com.rental.companyservice.entity.Company;
import com.rental.companyservice.entity.Groups;
import com.rental.companyservice.entity.Location;
import com.rental.companyservice.service.companies.CompanyDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public class EmployeeDto {
    @Getter
    private UUID id;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private CompanyDto company;
    @Getter @Setter
    private Location location;
    @Getter @Setter
    private Groups groups;
}
