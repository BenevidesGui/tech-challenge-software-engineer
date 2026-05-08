package org.example.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    @DisplayName("Deve preencher message e status corretamente e gerar timestamp")
    void givenMessageAndStatus_whenCreateErrorResponse_thenFieldsAreCorrect() {

        String message = "Erro interno";
        int status = 500;

        ErrorResponse response = new ErrorResponse(message, status);

        assertEquals(message, response.getMessage());
        assertEquals(status, response.getStatus());
        assertNotNull(response.getTimestamp());
    }
}