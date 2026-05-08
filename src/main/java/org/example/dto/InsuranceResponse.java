package org.example.dto;

public class InsuranceResponse {

    private CustomerResponse customer;

    public InsuranceResponse(CustomerResponse customer) {
        this.customer = customer;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }
}
