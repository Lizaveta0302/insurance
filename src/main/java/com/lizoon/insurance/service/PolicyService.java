package com.lizoon.insurance.service;

import com.lizoon.insurance.domain.Policy;
import com.lizoon.insurance.dto.PolicyCreateDto;

import java.util.List;

public interface PolicyService {

    Policy getPolicy(Long id);

    List<Policy> getAllPolicies();

    Policy createPolicy(PolicyCreateDto policyCreateDto);

    void deletePolicy(Long id);
}
