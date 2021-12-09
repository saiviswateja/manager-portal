package com.adinarayana.manager.portal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeePk;

    @NotNull
    private String firstName;

    private String lastName;

    private String address;

    private String birthDate;

    @NotNull
    private String companyName;

    @NotNull
    @Size(min = 10, max = 10)
    private String mobile;
}
