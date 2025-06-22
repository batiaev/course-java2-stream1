package com.batiaev.patterns.lesson6;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sg_person")
public class Person {
    @Column(name = "id")
    private long personId;
    private String firstName;
    private String lastName;
}
