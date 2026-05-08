package org.example.controllerTest;

import org.example.controller.InsuranceController;
import org.example.dto.*;
import org.example.service.InsuranceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InsuranceControllerTest {

    @Mock
    private InsuranceService insuranceService;

    @InjectMocks
    private InsuranceController insuranceController;

    @Test
    @DisplayName("Dado um customer válido, deve calcular o seguro e retornar a resposta esperada")
    void givenValidCustomer_whenCalculateInsurance_thenReturnExpectedResponse() {

        CustomerRequest customer = new CustomerRequest();
        customer.setName("João");
        customer.setLocation("SP");
        customer.setVehicle_value(70000);

        InsuranceRequest request = new InsuranceRequest();
        request.setCustomer(customer);

        CustomerResponse customerResponse =
                new CustomerResponse("João", "SP", 3500.0);

        InsuranceResponse expectedResponse =
                new InsuranceResponse(customerResponse);

        when(insuranceService.calculate(request))
                .thenReturn(expectedResponse);

        InsuranceResponse response = insuranceController.calculate(request);

        assertEquals("João", response.getCustomer().getName());
        assertEquals("SP", response.getCustomer().getLocation());
        assertEquals(3500.0, response.getCustomer().getValue());
    }
}