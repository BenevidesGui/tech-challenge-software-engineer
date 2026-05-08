package org.example.dtoTest;

import org.example.dto.CustomerRequest;
import org.example.dto.InsuranceRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerRequestTest {

    @Test
    @DisplayName("Dado um cliente, quando definir e recuperar dados, então deve retornar os mesmos dados")
    void givenCustomer_whenSetAndGetCustomer_thenReturnSameCustomer() {

        CustomerRequest customer = new CustomerRequest();
        customer.setName("João");
        customer.setLocation("SP");
        customer.setVehicle_value(70000);

        InsuranceRequest request = new InsuranceRequest();
        request.setCustomer(customer);

        CustomerRequest result = request.getCustomer();

        assertEquals("João", result.getName());
        assertEquals("SP", result.getLocation());
        assertEquals(70000, result.getVehicle_value());
    }
}
