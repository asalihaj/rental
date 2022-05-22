package com.rental.companyservice.repository;

import com.rental.companyservice.entity.Claims;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClaimsRepo extends JpaRepository<Claims, UUID> {
}
