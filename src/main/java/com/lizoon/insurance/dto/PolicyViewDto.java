package com.lizoon.insurance.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

/**
 * DTO представление сущности Policy
 */
@Value
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class PolicyViewDto {

    long id;

    int policyNumber;
    int totalAmount;

    boolean active;

    LocalDate effectiveDate;
    LocalDate expireDate;
}
