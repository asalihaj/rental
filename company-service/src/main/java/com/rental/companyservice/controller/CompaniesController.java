package com.rental.companyservice.controller;

import com.rental.companyservice.service.company.CompanyDTO;
import com.rental.companyservice.entity.Company;
import com.rental.companyservice.service.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {
    private CompanyService service;

    CompaniesController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> get(@PathVariable("id") UUID id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        return service.create(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> edit(@PathVariable("id") UUID id, @RequestBody Company company) {
        return service.edit(id, company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") UUID id) {
        return service.delete(id);
    }
}
