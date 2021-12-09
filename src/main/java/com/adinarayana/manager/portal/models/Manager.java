package com.adinarayana.manager.portal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerPk;

    @NotEmpty
    @Email
    private String emailId;

    @NotEmpty
    @Size(min = 2, message = "username should be atleast 2 characters")
    private String firstName;

    private String lastName;

    @NotEmpty
    @Size(min = 8, max = 16, message = "password should be 8 to 16 length")
    private String password;

    private String address;

    private String birthDate;

    @NotEmpty
    private String companyName;

    private int isAdmin;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;
}
