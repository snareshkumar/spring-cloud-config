package com.springcloud.insuranceclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/getallplans")
@RefreshScope
public class InsuranceClientController {

    @Autowired
    private RestTemplate template;

    @Value("${insurance-provider-url}")
    private String providerUrl;

    @GetMapping
    public Object[] getAllPlans() {
        ResponseEntity<Object[]> responseEntity = template.getForEntity(providerUrl, Object[].class);
        return responseEntity.getBody();
    }

}
