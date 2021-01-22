package com.lizoon.insurance.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lizoon.insurance.dto.PolicyCreateDto;
import com.lizoon.insurance.dto.PolicyViewDto;
import com.lizoon.insurance.mapper.PolicyMapper;
import com.lizoon.insurance.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/policy")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;
    private final PolicyMapper policyMapper;
    private final MappingJackson2XmlHttpMessageConverter xmlConverter;

    private static final String MEDIA_TYPE_JSON = "application/json";
    private static final String MEDIA_TYPE_XML = "application/xml";

    @GetMapping("/{id}")
    public ResponseEntity<PolicyViewDto> getPolicy(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(policyMapper.map(policyService.getPolicy(id)));
    }

    @GetMapping
    public ResponseEntity<List<PolicyViewDto>> getAllPoliciesInJsonFormat() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(policyMapper.map(policyService.getAllPolicies()));
    }

    @GetMapping(value = "/xmlFormat", produces = MEDIA_TYPE_XML)
    public ResponseEntity<?> getAllPoliciesInXmlFormat() throws JsonProcessingException {
        ObjectMapper xmlMapper = xmlConverter.getObjectMapper();
        return ResponseEntity.status(HttpStatus.OK)
                .body(xmlMapper.writeValueAsString(policyService.getAllPolicies()));
    }

    @PostMapping
    public ResponseEntity<PolicyViewDto> createPolicy(@RequestBody PolicyCreateDto policyCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(policyMapper.map(policyService.createPolicy(policyCreateDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
