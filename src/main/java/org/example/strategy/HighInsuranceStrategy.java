package org.example.strategy;

import org.example.dto.CustomerRequest;
import org.example.service.InsuranceStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class HighInsuranceStrategy implements InsuranceStrategy {

    @Value("${insurance.high.rate}")
    private double maxRate;

    @Value("${insurance.vehicle.threshold.high}")
    private double vehicleValueMax;

    @Override
    public boolean applies(CustomerRequest customer) {

        return customer.getVehicle_value() > vehicleValueMax;
    }

    @Override
    public double calculate(CustomerRequest customer) {

        return customer.getVehicle_value() * maxRate;
    }
}
