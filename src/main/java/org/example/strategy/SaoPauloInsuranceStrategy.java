package org.example.strategy;

import org.example.dto.CustomerRequest;
import org.example.service.InsuranceStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SaoPauloInsuranceStrategy implements InsuranceStrategy {

    @Value("${insurance.sp.rate}")
    private double rate;

    @Value("${insurance.sp.location}")
    private String spLocation;

    @Value("${insurance.vehicle.threshold.low}")
    private double vehicleValueMediumSp;

    @Override
    public boolean applies(CustomerRequest customer) {

        return customer.getVehicle_value() <= vehicleValueMediumSp
                && customer.getLocation().equals(spLocation);
    }

    @Override
    public double calculate(CustomerRequest customer) {

        return customer.getVehicle_value() * rate;
    }
}