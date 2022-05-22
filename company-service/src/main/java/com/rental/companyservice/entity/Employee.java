package com.rental.companyservice.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "username", nullable = false)
    @NotNull
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(
            name = "location_id",
            referencedColumnName = "id",
            insertable = false,
            nullable = false,
            updatable = false)
    private Location location;

    @ManyToOne
    @NotNull
    @JoinColumn(
            name = "company_id",
            referencedColumnName = "id",
            nullable = false,
            insertable = false,
            updatable = false)
    private Company company;

    @ManyToOne
    @NotNull
    @JoinColumn(
            name = "group_id",
            referencedColumnName = "id",
            nullable = false,
            insertable = false,
            updatable = false)
    private Groups groups;

    public Employee() {
    }

    public Employee(UUID id, String username, String password, Company company, Location location) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.company = company;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}
