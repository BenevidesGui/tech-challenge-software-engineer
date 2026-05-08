package org.example.strategyTest;

import org.example.dto.CustomerRequest;
import org.example.strategy.HighInsuranceStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = org.example.application.Main.class)
@ActiveProfiles("test")
class HighInsuranceStrategyTest {

    @Autowired
    private HighInsuranceStrategy strategy;

    private static final double VEHICLE_ABOVE_THRESHOLD = 120000.0;
    private static final double VEHICLE_BELOW_THRESHOLD = 80000.0;

    @Test
    @DisplayName("Deve retornar true quando veículo está acima do limite configurado")
    void givenVehicleAboveThreshold_whenApplies_thenReturnTrue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VEHICLE_ABOVE_THRESHOLD);

        boolean result = strategy.applies(customer);

        assertTrue(result);
    }

    @Test
    @DisplayName("Deve retornar false quando veículo está abaixo do limite configurado")
    void givenVehicleBelowThreshold_whenApplies_thenReturnFalse() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VEHICLE_BELOW_THRESHOLD);

        boolean result = strategy.applies(customer);

        assertFalse(result);
    }

    @Test
    @DisplayName("Deve calcular valor corretamente com taxa configurada no profile")
    void givenVehicleValue_whenCalculate_thenReturnCorrectValue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(100000.0);

        double result = strategy.calculate(customer);

        double expected = 100000.0 * 0.06;

        assertEquals(expected, result);
    }
}