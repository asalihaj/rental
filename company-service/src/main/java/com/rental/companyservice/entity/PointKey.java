package com.rental.companyservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class PointKey implements Serializable {
    @Getter
    @Setter
    private UUID companyId;
    @Getter
    @Setter
    private UUID locationId;

    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointKey pointKey = (PointKey) o;
        return companyId.equals(pointKey.companyId)
                && locationId.equals(pointKey.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, locationId);
    }
}
