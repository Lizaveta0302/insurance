package com.lizoon.insurance.service;

import com.lizoon.insurance.domain.Policy;
import com.lizoon.insurance.dto.PolicyCreateDto;
import com.lizoon.insurance.exception.NotFoundException;
import com.lizoon.insurance.mapper.PolicyMapper;
import com.lizoon.insurance.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final PolicyMapper policyMapper;

    @Override
    public Policy getPolicy(Long id) {

        Optional<Policy> policy = policyRepository.findById(id);

        if (!policy.isPresent()) {
            throw new NotFoundException("Policy with id " + id + " is not found.", "id");
        }

        return policy.get();
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    @Transactional
    public Policy createPolicy(PolicyCreateDto policyCreateDto) {

        Policy policy = policyMapper.map(policyCreateDto);

        policyRepository.save(policy);

        return policy;
    }

    @Override
    @Transactional
    public void deletePolicy(Long id) {

        Optional<Policy> policy = policyRepository.findById(id);

        if (!policy.isPresent()) {
            throw new NotFoundException("Policy with id " + id + " is not found.", "id");
        }
        policyRepository.delete(policy.get());
    }
}
