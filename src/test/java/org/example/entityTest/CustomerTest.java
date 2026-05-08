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
        Customer consumer = new Customer();

        consumer.setName("João");
        consumer.setDocument("123456789");
        consumer.setBirthDay(birthDate);
        consumer.setLocation("SP");
        consumer.setvValue(70000.0);

        assertEquals("João", consumer.getName());
        assertEquals("123456789", consumer.getDocument());
        assertEquals(birthDate, consumer.getBirthDay());
        assertEquals("SP", consumer.getLocation());
        assertEquals(70000.0, consumer.getvValue());
    }

    @Test
    @DisplayName("Dado parâmetros válidos, quando criar Consumer, então campos corretos")
    void givenValidParameters_whenCreateConsumer_thenFieldsAreCorrect() {

        Date birthDate = new Date();

        Customer consumer = new Customer(
                "João",
                "123456789",
                birthDate,
                "SP",
                70000.0
        );

        assertEquals("João", consumer.getName());
        assertEquals("123456789", consumer.getDocument());
        assertEquals(birthDate, consumer.getBirthDay());
        assertEquals("SP", consumer.getLocation());
        assertEquals(70000.0, consumer.getvValue());
    }
}
