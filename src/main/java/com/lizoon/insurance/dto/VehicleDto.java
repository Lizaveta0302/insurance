package com.lizoon.insurance.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * DTO представление сущности Vehicle
 */
@Value
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class VehicleDto {

    long id;
    int number;
    String model;
}
