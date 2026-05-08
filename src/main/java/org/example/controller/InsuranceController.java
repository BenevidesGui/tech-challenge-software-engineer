package org.example.controller;

import jakarta.validation.Valid;
import org.example.service.InsuranceService;
import org.example.dto.InsuranceRequest;
import org.example.dto.InsuranceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private static final Logger logger = LoggerFactory.getLogger(InsuranceController.class);

    @Autowired
    private  InsuranceService insuranceService;

    @PostMapping
    public InsuranceResponse calculate(@Valid@RequestBody InsuranceRequest request) {
        InsuranceResponse response = insuranceService.calculate(request);
        logger.info("Resposta calculada");
        return response;
    }
}
