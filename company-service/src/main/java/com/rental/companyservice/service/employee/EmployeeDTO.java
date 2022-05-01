package com.rental.companyservice.service.employee;

import com.rental.companyservice.service.company.CompanyDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class EmployeeDTO {
    private String username;
    private String email;
    private String password;
    private Date dateCreated;
    private CompanyDTO company;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated() {
        this.dateCreated = new Date();
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
