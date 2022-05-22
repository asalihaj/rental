package com.rental.companyservice.repository;

import com.rental.companyservice.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupsRepo extends JpaRepository<Groups, UUID> {
}
