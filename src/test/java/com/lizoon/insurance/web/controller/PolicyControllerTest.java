package com.lizoon.insurance.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lizoon.insurance.domain.Policy;
import com.lizoon.insurance.dto.PolicyViewDto;
import com.lizoon.insurance.mapper.PolicyMapper;
import com.lizoon.insurance.mapper.PolicyMapperImpl;
import com.lizoon.insurance.service.PolicyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PolicyController.class)
public class PolicyControllerTest {

    @TestConfiguration
    static class Configuration {
        @Bean
        public PolicyMapper policyMapper() {
            return new PolicyMapperImpl();
        }

        @Bean
        public MappingJackson2XmlHttpMessageConverter xmlConverter() {
            return new MappingJackson2XmlHttpMessageConverter();
        }
    }

    @MockBean
    private PolicyService policyService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private String policyJsonDto;

    private Policy testPolicy;
    private PolicyViewDto policyViewDto;

    private List<Policy> testPolicyList;

    @Before
    public void setUp() throws JsonProcessingException {

        testPolicyList = LongStream.rangeClosed(1, 10)
                .mapToObj(id -> new Policy())
                .collect(Collectors.toList());

        testPolicy = new Policy();
        testPolicy.setId(100);

        policyViewDto = PolicyViewDto.builder()
                .withId(100L)
                .build();

        policyJsonDto = objectMapper.writeValueAsString(policyViewDto);
    }

    @Test
    public void whenGetPolicy_thenGetPolicy() throws Exception {
        when(policyService.getPolicy(100L)).thenReturn(testPolicy);

        mockMvc.perform(get("/{id}", 100))
                .andExpect(status().isOk())
                .andExpect(content().json(policyJsonDto));

        verify(policyService).getPolicy(100L);
    }

    @Test
    public void whenGetAllPolicy_thenGetAllPolicy() throws Exception {
        when(policyService.getAllPolicies()).thenReturn(testPolicyList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(testPolicyList.size())));
    }

    @Test
    public void whenDeletePolicy_thenPolicyServiceInvoked() throws Exception {
        mockMvc.perform(delete("/{id}", 100));

        verify(policyService).deletePolicy(100L);
    }
}
