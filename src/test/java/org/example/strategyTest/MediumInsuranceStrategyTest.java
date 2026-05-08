package org.example.strategyTest;

import org.example.dto.CustomerRequest;
import org.example.strategy.MediumInsuranceStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = org.example.application.Main.class)
@ActiveProfiles("test")
class MediumInsuranceStrategyTest {

    @Autowired
    private MediumInsuranceStrategy strategy;

    private static final double VALUE_INSIDE_RANGE = 85000.0;
    private static final double VALUE_BELOW_RANGE = 60000.0;
    private static final double VALUE_ABOVE_RANGE = 120000.0;

    @Test
    @DisplayName("Deve aplicar estratégia quando veículo está dentro da faixa média")
    void givenVehicleInMediumRange_whenApplies_thenReturnTrue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_INSIDE_RANGE);

        boolean result = strategy.applies(customer);

        assertTrue(result);
    }

    @Test
    @DisplayName("Não deve aplicar estratégia quando veículo está abaixo da faixa média")
    void givenVehicleBelowRange_whenApplies_thenReturnFalse() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_BELOW_RANGE);

        boolean result = strategy.applies(customer);

        assertFalse(result);
    }

    @Test
    @DisplayName("Não deve aplicar estratégia quando veículo está acima da faixa média")
    void givenVehicleAboveRange_whenApplies_thenReturnFalse() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_ABOVE_RANGE);

        boolean result = strategy.applies(customer);

        assertFalse(result);
    }

    @Test
    @DisplayName("Deve calcular valor corretamente usando rate do environment de test")
    void givenVehicleValue_whenCalculate_thenReturnCorrectValue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_INSIDE_RANGE);

        double result = strategy.calculate(customer);

        double expected = VALUE_INSIDE_RANGE * strategy.calculate(customer) / VALUE_INSIDE_RANGE;

        assertEquals(85000.0 * 0.055, result);
    }
}
