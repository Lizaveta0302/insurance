package com.lizoon.insurance.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "policy_number")
    private int policyNumber;
    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "active")
    private boolean active;

    @Column(name = "effectivedate")
    private LocalDate effectiveDate;
    @Column(name = "expire_date")
    private LocalDate expireDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "policy")
    private Set<Vehicle> vehicles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "policies_coverages",
            joinColumns = @JoinColumn(name = "policy_id"),
            inverseJoinColumns = @JoinColumn(name = "coverage_id"))
    private Set<Coverage> coverages;
}
