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
    @DisplayName("Deve retornar 400 quando name for inválido")
    void shouldReturnBadRequest_whenNameIsInvalid() throws Exception {

        mockMvc.perform(post("/insurance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "customer": {
                "name": "",
                "document": "123.456.789-10",
                "birthday": "1990-07-10",
                "location": "SP",
                "vehicle_value": 10000
              }
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Name is required"));
    }

    @Test
    @DisplayName("Deve retornar 400 quando document for inválido")
    void shouldReturnBadRequest_whenDocumentIsInvalid() throws Exception {

        mockMvc.perform(post("/insurance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "customer": {
                "name": "João",
                "document": "",
                "birthday": "1990-07-10",
                "location": "SP",
                "vehicle_value": 10000
              }
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Document is required"));
    }

    @Test
    @DisplayName("Deve retornar 400 quando birthday for inválido")
    void shouldReturnBadRequest_whenBirthdayIsInvalid() throws Exception {

        mockMvc.perform(post("/insurance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "customer": {
                "name": "João",
                "document": "123.456.789-10",
                "birthday": "",
                "location": "SP",
                "vehicle_value": 10000
              }
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Birthday is required"));
    }

    @Test
    @DisplayName("Deve retornar 400 quando location for inválido")
    void shouldReturnBadRequest_whenLocationIsInvalid() throws Exception {

        mockMvc.perform(post("/insurance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "customer": {
                "name": "João",
                "document": "123.456.789-10",
                "birthday": "1990-07-10",
                "location": "",
                "vehicle_value": 10000
              }
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Location is required"));
    }

    @Test
    @DisplayName("Deve retornar 400 quando vehicle_value for inválido")
    void shouldReturnBadRequest_whenVehicleValueIsInvalid() throws Exception {

        mockMvc.perform(post("/insurance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "customer": {
                "name": "João",
                "document": "123.456.789-10",
                "birthday": "1990-07-10",
                "location": "SP",
                "vehicle_value": -10
              }
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Vehicle value must be greater than zero"));
    }
}