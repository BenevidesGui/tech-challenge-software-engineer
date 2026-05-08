package org.example.strategyTest;

import org.example.dto.CustomerRequest;
import org.example.strategy.StandardInsuranceStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest(classes = org.example.application.Main.class)
@ActiveProfiles("test")
class StandardInsuranceStrategyTest {

    @Autowired
    private StandardInsuranceStrategy strategy;

    @Value("${insurance.sp.location}")
    private String spLocation;

    private static final double VALUE_LOW = 60000.0;

    @Test
    @DisplayName("Deve aplicar estratégia quando veículo está abaixo do limite e não é SP")
    void givenLowValueAndNotSP_whenApplies_thenReturnTrue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_LOW);
        when(customer.getLocation()).thenReturn("RJ");

        assertTrue(strategy.applies(customer));
    }

    @Test
    @DisplayName("Não deve aplicar estratégia quando veículo está abaixo do limite e é SP")
    void givenLowValueAndSP_whenApplies_thenReturnFalse() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(VALUE_LOW);
        when(customer.getLocation()).thenReturn(spLocation);

        assertFalse(strategy.applies(customer));
    }

    @Test
    @DisplayName("Deve calcular valor corretamente usando rate do environment de test")
    void givenVehicleValue_whenCalculate_thenReturnCorrectValue() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(100000.0);

        double result = strategy.calculate(customer);

        assertEquals(100000.0 * 0.04, result);
    }

    @Test
    @DisplayName("Não deve aplicar estratégia quando veículo está acima do limite")
    void givenHighValue_whenApplies_thenReturnFalse() {

        CustomerRequest customer = new CustomerRequest();
        customer.setVehicle_value(200000.0);
        customer.setLocation("RJ");

        assertFalse(strategy.applies(customer));
    }
}