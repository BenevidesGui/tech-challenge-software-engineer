package org.example.strategyTest;

import org.example.dto.CustomerRequest;
import org.example.strategy.SaoPauloInsuranceStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = org.example.application.Main.class)
@ActiveProfiles("test")
class SaoPauloInsuranceStrategyTest {

    @Autowired
    private SaoPauloInsuranceStrategy strategy;

    private static final double VALUE_BELOW_THRESHOLD = 60000.0;
    private static final double VALUE_ABOVE_THRESHOLD = 80000.0;

    private static final String SP_LOCATION = "SP";
    private static final String OTHER_LOCATION = "RJ";

    @Test
    @DisplayName("Deve aplicar estratégia para veículo abaixo do limite em SP")
    void givenVehicleBelowThresholdInSP_whenApplies_thenReturnTrue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_BELOW_THRESHOLD);
        when(customer.getLocation()).thenReturn(SP_LOCATION);

        boolean result = strategy.applies(customer);

        assertTrue(result);
    }

    @Test
    @DisplayName("Não deve aplicar estratégia quando não for SP")
    void givenVehicleInSPButWrongLocation_whenApplies_thenReturnFalse() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_BELOW_THRESHOLD);
        when(customer.getLocation()).thenReturn(OTHER_LOCATION);

        boolean result = strategy.applies(customer);

        assertFalse(result);
    }

    @Test
    @DisplayName("Não deve aplicar estratégia quando veículo acima do limite")
    void givenVehicleAboveThreshold_whenApplies_thenReturnFalse() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_ABOVE_THRESHOLD);
        when(customer.getLocation()).thenReturn(SP_LOCATION);

        boolean result = strategy.applies(customer);

        assertFalse(result);
    }

    @Test
    @DisplayName("Deve calcular valor corretamente usando rate do environment de test")
    void givenValidCustomer_whenCalculate_thenReturnCorrectValue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_BELOW_THRESHOLD);

        double result = strategy.calculate(customer);

        double expected = VALUE_BELOW_THRESHOLD * strategy.calculate(customer) / VALUE_BELOW_THRESHOLD;

        assertEquals(60000.0 * 0.05, result);
    }
}
