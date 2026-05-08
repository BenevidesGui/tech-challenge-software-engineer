package org.example.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyNotFoundExceptionTest {

    @Test
    @DisplayName("Deve criar a StrategyNotFoundException com a mensagem correta")
    void shouldCreateExceptionWithMessage() {
        String message = "No strategy found";

        StrategyNotFoundException ex =
                new StrategyNotFoundException(message);

        assertEquals(message, ex.getMessage());
    }
}