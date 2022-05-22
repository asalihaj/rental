package com.rental.companyservice.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccessListKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groups;

    @ManyToOne
    @JoinColumn(name = "claims_id")
    private Claims claims;

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessListKey accessListKey = (AccessListKey) o;
        return groups.equals(accessListKey.groups)
                && claims.equals(accessListKey.claims);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups, claims);
    }
}
