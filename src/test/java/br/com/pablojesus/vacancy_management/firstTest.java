package br.com.pablojesus.vacancy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class firstTest {
    
    @Test
    public void it_should_be_possible_to_calculate_two_numbers() {
        var result = calculate(2, 5);
        assertEquals(result, 7);
    }

    @Test
    public void validate_incorrect_value() {
        var result = calculate(2, 5);
        assertNotEquals(result, 4);
    }

    public static int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
