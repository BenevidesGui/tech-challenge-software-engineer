package org.example.dto;

import jakarta.validation.Valid;

public class InsuranceRequest {

    @Valid
    private CustomerRequest customer;

    public InsuranceRequest() {
    }

    public CustomerRequest getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRequest customer) {
        this.customer = customer;
    }
}