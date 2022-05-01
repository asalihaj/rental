package com.rental.companyservice.repository;

import com.rental.companyservice.entity.Company;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository  extends JpaRepository<Company, UUID> {
}