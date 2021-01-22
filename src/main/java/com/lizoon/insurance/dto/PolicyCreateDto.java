package com.lizoon.insurance.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

/**
 * DTO представление сущности Policy
 */
@Value
@AllArgsConstructor
@Builder(setterPrefix = "with")
@JsonDeserialize(builder = PolicyCreateDto.PolicyCreateDtoBuilder.class)
public class PolicyCreateDto {

    @NonNull
    int policyNumber;
    @NonNull
    int totalAmount;

    LocalDate effectiveDate;
    LocalDate expireDate;
}
