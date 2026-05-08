package org.example.service;

import org.example.dto.CustomerRequest;
import org.example.dto.CustomerResponse;
import org.example.dto.InsuranceRequest;
import org.example.dto.InsuranceResponse;
import org.example.exception.StrategyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    private final List<InsuranceStrategy> strategies;
    private static final Logger logger = LoggerFactory.getLogger(InsuranceService.class);

    public InsuranceService(List<InsuranceStrategy> strategies) {
        this.strategies = strategies;
    }

    public InsuranceResponse calculate(InsuranceRequest request) {

        CustomerRequest customer = request.getCustomer();

        InsuranceStrategy strategy = strategies.stream()
                .filter(s -> s.applies(customer))
                .findFirst()
                .orElseThrow(() ->
                        new StrategyNotFoundException("No insurance strategy found")
                );
        logger.info("Using strategy: {}", strategy.getClass().getSimpleName());

        double insuranceValue = strategy.calculate(customer);

        CustomerResponse customerResponse =
                new CustomerResponse(customer.getName(), customer.getLocation(), insuranceValue);

        logger.info("Insurance calculated successfully");
        return new InsuranceResponse(customerResponse);
    }
}
