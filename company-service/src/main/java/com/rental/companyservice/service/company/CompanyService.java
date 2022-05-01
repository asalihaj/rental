package com.rental.companyservice.service.company;

import com.rental.companyservice.entity.Company;
import com.rental.companyservice.repository.CompanyRepository;
import com.rental.companyservice.service.MappingProfile;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CompanyService {
    private CompanyRepository repository;
    private MappingProfile mapper;

    CompanyService(CompanyRepository repository, MappingProfile mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public ResponseEntity<List<CompanyDTO>> list() {
        try {
            List<CompanyDTO> companies = new ArrayList<>();
            List<Company> companyModel = repository.findAll();

            for (Company company : companyModel) {
                companies.add(mapper.map(company));
            }

            return new ResponseEntity<>(companies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Company> get(UUID id) {
        try {
            Optional<Company> company = repository.findById(id);
            if (company.isPresent()) {
                return  new ResponseEntity<>(company.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Company> create(Company company) {
        try {
            Company _company = repository
                    .save(new Company(company.getName(), company.getLocation()));
            return new ResponseEntity<>(_company, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Company> edit(UUID id, Company company) {
        Optional<Company> companyData = repository.findById(id);
        if (companyData.isPresent()) {
            Company _company = companyData.get();
            _company.setName(company.getName());
            _company.setLocation(company.getLocation());
            return new ResponseEntity<>(repository.save(_company), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> delete(UUID id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
