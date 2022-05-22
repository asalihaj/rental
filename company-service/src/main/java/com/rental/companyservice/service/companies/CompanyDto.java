package com.rental.companyservice.service.companies;

import lombok.Data;

import java.util.UUID;

@Data
public class CompanyDto {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
