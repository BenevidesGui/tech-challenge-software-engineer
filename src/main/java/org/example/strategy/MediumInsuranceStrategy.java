package org.example.strategy;

import org.example.dto.CustomerRequest;
import org.example.service.InsuranceStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MediumInsuranceStrategy implements InsuranceStrategy {


    @Value("${insurance.medium.rate}")
    private double mediumRate;

    @Value("${insurance.vehicle.threshold.low}")
    private double vehicleValueMedium;

    @Value("${insurance.vehicle.threshold.high}")
    private double vehicleValueMax;

    @Override
    public boolean applies(CustomerRequest customer) {

        return customer.getVehicle_value() > vehicleValueMedium
                && customer.getVehicle_value() < vehicleValueMax;
    }

    @Override
    public double calculate(CustomerRequest customer) {

        return customer.getVehicle_value() * mediumRate;
    }
}

