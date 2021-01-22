package com.lizoon.insurance.mapper;

import com.lizoon.insurance.domain.Policy;
import com.lizoon.insurance.dto.PolicyCreateDto;
import com.lizoon.insurance.dto.PolicyViewDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * Маппер сущности Policy.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PolicyMapper {

    PolicyViewDto map(Policy policy);

    List<PolicyViewDto> map(List<Policy> policies);

    Policy map(PolicyCreateDto policyCreateDto);
}
