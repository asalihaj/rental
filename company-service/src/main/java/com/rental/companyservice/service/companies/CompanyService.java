package com.rental.companyservice.service.companies;

import com.rental.companyservice.entity.Company;
import com.rental.companyservice.repository.CompanyRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CompanyService {
    private final CompanyRepo repository;
    private final CompanyMapper mapper;

    CompanyService(CompanyRepo repository, CompanyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CompanyDto> list() {
        try {
            List<Company> companies = repository.findAll();
            return mapper.map(companies);
        } catch (Exception e) {
            throw e;
        }
    }

    public CompanyDto get(UUID id) throws Exception {
        try {
            Optional<Company> company = repository.findById(id);
            if(company.isPresent()) {
                return mapper.map(company.get());
            }
            throw new Exception("Not found");
        } catch (Exception e) {
            throw e;
        }
    }
}
