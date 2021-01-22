package com.lizoon.insurance.repository;

import com.lizoon.insurance.domain.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
