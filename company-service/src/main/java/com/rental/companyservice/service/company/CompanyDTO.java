package com.rental.companyservice.service.company;

import lombok.Data;

import java.util.UUID;

@Data
public class CompanyDTO {
    private UUID id;
    private String name;
    private String location;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
