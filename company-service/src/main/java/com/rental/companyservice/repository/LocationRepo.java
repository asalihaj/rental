package com.rental.companyservice.repository;

import com.rental.companyservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepo extends JpaRepository<Location, UUID> {
}
