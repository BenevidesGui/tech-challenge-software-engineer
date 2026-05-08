package org.example.entityTest;

import org.example.entity.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    @DisplayName("Dado um Consumer, quando usar setters e getters, " +
            "então os valores devem ser retornados corretamente")
    void givenConsumer_whenSetAndGet_thenValuesAreCorrect() {
        Date birthDate = new Date();
        Customer customer = new Customer();

        customer.setName("João");
        customer.setDocument("123456789");
        customer.setBirthDay(birthDate);
        customer.setLocation("SP");
        customer.setvValue(70000.0);

        assertEquals("João", customer.getName());
        assertEquals("123456789", customer.getDocument());
        assertEquals(birthDate, customer.getBirthDay());
        assertEquals("SP", customer.getLocation());
        assertEquals(70000.0, customer.getvValue());
    }

    @Test
    @DisplayName("Dado parâmetros válidos, quando criar Consumer, então campos corretos")
    void givenValidParameters_whenCreateConsumer_thenFieldsAreCorrect() {

        Date birthDate = new Date();

        Customer customer = new Customer(
                "João",
                "123456789",
                birthDate,
                "SP",
                70000.0
        );

        assertEquals("João", customer.getName());
        assertEquals("123456789", customer.getDocument());
        assertEquals(birthDate, customer.getBirthDay());
        assertEquals("SP", customer.getLocation());
        assertEquals(70000.0, customer.getvValue());
    }
}
