package org.example.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    @DisplayName("Deve retornar 404 quando nenhuma estratégia de seguro for encontrada")
    void shouldHandleStrategyNotFoundException() {
        StrategyNotFoundException ex = new StrategyNotFoundException("No strategy found");

        ResponseEntity<ErrorResponse> response = handler.handleStrategyNotFound(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No strategy found", response.getBody().getMessage());
        assertEquals(404, response.getBody().getStatus());
    }
}
