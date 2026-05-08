package org.example.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = org.example.application.Main.class)
@AutoConfigureMockMvc
class InsuranceValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve retornar 400 quando o customer for inválido")
    void shouldReturnBadRequest_whenCustomerIsInvalid() throws Exception {

        mockMvc.perform(post("/insurance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                {
                  "customer": {
                    "name": "",
                    "document": "",
                    "birthday": "",
                    "location": "",
                    "vehicle_value": -10
                  }
                }
                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").exists());
    }
}