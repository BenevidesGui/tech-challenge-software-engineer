package org.example.entityTest;

import org.example.entity.CustomerResponseEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerResponseEntityTest {

    @Test
    @DisplayName("CustomerResponse deve armazenar e retornar corretamente todos os valores")
    void givenValidValues_whenCreateCustomerResponse_thenAllFieldsAreCorrect() {
        String name = "Guilherme";
        String location = "São Paulo";
        double value = 150.0;

        CustomerResponseEntity response = new CustomerResponseEntity(name, location, value);

        assertEquals(name, response.getName());
        assertEquals(location, response.getLocation());
        assertEquals(value, response.getValue());
    }
}
