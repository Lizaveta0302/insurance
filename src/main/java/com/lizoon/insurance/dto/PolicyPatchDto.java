package com.lizoon.insurance.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@JsonDeserialize(builder = PolicyPatchDto.PolicyPatchDtoBuilder.class)
public class PolicyPatchDto {

    int policyNumber;
    int totalAmount;

    LocalDate effectiveDate;
    LocalDate expireDate;
}
