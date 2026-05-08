package org.example.service;

import org.example.dto.CustomerRequest;

public interface InsuranceStrategy {

    boolean applies(CustomerRequest customer);

    double calculate(CustomerRequest customer);
}
