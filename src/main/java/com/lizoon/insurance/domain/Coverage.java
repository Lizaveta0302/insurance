package com.lizoon.insurance.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "coverages")
public class Coverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "code")
    private int code;

    @Column(name = "coverage_name")
    private String coverageName;
    @Column(name = "coverage_group")
    private String coverageGroup;
}
