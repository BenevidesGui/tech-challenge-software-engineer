package org.example.serviceTest;

import org.example.dto.CustomerRequest;
import org.example.dto.InsuranceRequest;
import org.example.dto.InsuranceResponse;
import org.example.exception.StrategyNotFoundException;
import org.example.service.InsuranceService;
import org.example.service.InsuranceStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class InsuranceServiceTest {

    @Test
    @DisplayName("Deve aplicar 4% para veículo até 70k")
    void givenVehicleUpTo70k_whenCalculate_thenApply4Percent() {

        CustomerRequest customer = mock(CustomerRequest.class);

        when(customer.getVehicle_value()).thenReturn(70000.0);
        when(customer.getLocation()).thenReturn("OUTRA");

        InsuranceRequest request = mock(InsuranceRequest.class);
        when(request.getCustomer()).thenReturn(customer);

        InsuranceStrategy strategy = mock(InsuranceStrategy.class);
        when(strategy.applies(customer)).thenReturn(true);
        when(strategy.calculate(customer)).thenReturn(2800.0);

        InsuranceService service = new InsuranceService(List.of(strategy));

        InsuranceResponse response = service.calculate(request);

        assertEquals(2800.0, response.getCustomer().getValue());
    }

    @Test
    @DisplayName("Deve aplicar 5% para veículo até 70k em SP")
    void givenVehicleUpTo70kAndSP_whenCalculate_thenApply5Percent() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(70000.0);
        when(customer.getLocation()).thenReturn("SP");

        InsuranceRequest request = mock(InsuranceRequest.class);
        when(request.getCustomer()).thenReturn(customer);

        InsuranceStrategy strategy = mock(InsuranceStrategy.class);
        when(strategy.applies(customer)).thenReturn(true);
        when(strategy.calculate(customer)).thenReturn(3500.0);

        InsuranceService service = new InsuranceService(List.of(strategy));

        InsuranceResponse response = service.calculate(request);

        assertEquals(3500.0, response.getCustomer().getValue());
    }

    @Test
    @DisplayName("Deve aplicar 5.5% para veículo entre 70k e 100k")
    void givenVehicleBetween70kAnd100k_whenCalculate_thenApply55Percent() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(90000.0);
        when(customer.getLocation()).thenReturn("SP");

        InsuranceRequest request = mock(InsuranceRequest.class);
        when(request.getCustomer()).thenReturn(customer);

        InsuranceStrategy strategy = mock(InsuranceStrategy.class);
        when(strategy.applies(customer)).thenReturn(true);
        when(strategy.calculate(customer)).thenReturn(4950.0);

        InsuranceService service = new InsuranceService(List.of(strategy));

        InsuranceResponse response = service.calculate(request);

        assertEquals(4950.0, response.getCustomer().getValue());
    }

    @Test
    @DisplayName("Deve aplicar 6% para veículo acima de 100k")
    void givenVehicleAbove100k_whenCalculate_thenApply6Percent() {

        CustomerRequest customer = mock(CustomerRequest.class);
        when(customer.getVehicle_value()).thenReturn(120000.0);
        when(customer.getLocation()).thenReturn("SP");

        InsuranceRequest request = mock(InsuranceRequest.class);
        when(request.getCustomer()).thenReturn(customer);

        InsuranceStrategy strategy = mock(InsuranceStrategy.class);
        when(strategy.applies(customer)).thenReturn(true);
        when(strategy.calculate(customer)).thenReturn(7200.0);

        InsuranceService service = new InsuranceService(List.of(strategy));

        InsuranceResponse response = service.calculate(request);

        assertEquals(7200.0, response.getCustomer().getValue());
    }

    @Test
    @DisplayName("Deve lançar exceção quando nenhuma strategy for encontrada")
    void givenNoStrategy_whenCalculate_thenThrowException() {

        CustomerRequest customer = mock(CustomerRequest.class);
        InsuranceRequest request = mock(InsuranceRequest.class);
        when(request.getCustomer()).thenReturn(customer);

        InsuranceStrategy strategy = mock(InsuranceStrategy.class);
        when(strategy.applies(customer)).thenReturn(false);

        InsuranceService service = new InsuranceService(List.of(strategy));

        assertThrows(
                StrategyNotFoundException.class,
                () -> service.calculate(request)
        );
    }
}
