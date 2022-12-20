package com.springcloud.insuranceprovider.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getallplans")
public class InsuranceProviderController {

    @GetMapping
    public ResponseEntity<List<String>> getInsurancePlans() {
        return ResponseEntity.ok().body(Arrays.asList("Jeevan Ananth", "Golden Premium", "Slver Premium"));
    }

}
