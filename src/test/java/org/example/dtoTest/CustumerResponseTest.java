package org.example.dtoTest;

import org.example.dto.CustomerResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerResponseEntityTest {

    @Test
    @DisplayName("Deve criar CustomerResponse corretamente com valores válidos")
    void givenValidValues_whenCreateCustomerResponse_thenFieldsAreCorrect() {
        CustomerResponse response = new CustomerResponse("João", "SP", 1000.0);

        assertEquals("João", response.getName());
        assertEquals("SP", response.getLocation());
        assertEquals(1000.0, response.getValue());
    }

    @Test
    @DisplayName("Dado um CustomerResponse, quando os setters forem utilizados, " +
            "então os valores devem ser atualizados corretamente")
    void givenCustomerResponse_whenUsingSetters_thenValuesAreUpdatedCorrectly() {

        CustomerResponse response =
                new CustomerResponse("Initial", "BR", 0.0);

        response.setName("João");
        response.setLocation("SP");
        response.setValue(2500.0);

        assertEquals("João", response.getName());
        assertEquals("SP", response.getLocation());
        assertEquals(2500.0, response.getValue());
    }
}
