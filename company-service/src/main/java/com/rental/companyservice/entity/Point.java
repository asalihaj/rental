package com.rental.companyservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "points")
public class Point {
    @EmbeddedId
    @Getter
    @Setter
    private PointKey key;

    public Point() {
    }

    public Point(PointKey key) {
        this.key = key;
    }
}
