package com.lizoon.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * DTO представление сущности Policy
 */
@Value
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class CoverageDto {

    long id;
    int code;
    String coverageName;
    String coverageGroup;
}
