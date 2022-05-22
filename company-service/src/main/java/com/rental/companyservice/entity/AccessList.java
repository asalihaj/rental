package com.rental.companyservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

public class AccessList {
    @EmbeddedId
    @Getter
    @Setter
    private AccessListKey key;

    public AccessList() {
    }

    public AccessList(AccessListKey key) {
        this.key = key;
    }
}
