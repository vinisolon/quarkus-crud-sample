package com.vinisolon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "customers")
public class Customer extends PanacheEntity {

    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private String email;

    @JsonIgnore
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @JsonIgnore
    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
