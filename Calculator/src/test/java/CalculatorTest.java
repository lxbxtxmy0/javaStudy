import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc = new Calculator();
    @Test
    void calculate() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(null, null, null));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("", "", ""));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("1", "+", "I"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("I", "+", "1"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("привет", "+", "I"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("1", "+", "привет"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("I", "+", "привет"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("привет", "+", "I"));

        assertThrows(IllegalArgumentException.class, () -> calc.calculate("привет", "%", "I"));

        assertThrows(IllegalArgumentException.class, () -> calc.calculate("I", "-", "II"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("1", "-", "2"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("1", "/", "2"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("I", "/", "II"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("XXX", "+", "XXX"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("30", "+", "30"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("30", "*", "30"));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("XXX", "*", "XXX"));

        assertEquals("II", calc.calculate("I","+", "I"));
        assertEquals("2", calc.calculate("1","+", "1"));
        assertEquals("XXXI", calc.calculate("XV","+", "XVI"));
        assertEquals("31", calc.calculate("15","+", "16"));

        assertEquals("I", calc.calculate("XV","-", "XIV"));
        assertEquals("1", calc.calculate("15","-", "14"));
        assertEquals("XXIII", calc.calculate("XXXIX","-", "XVI"));
        assertEquals("23", calc.calculate("39","-", "16"));

        assertEquals("XVIII", calc.calculate("VI","*", "III"));
        assertEquals("18", calc.calculate("6","*", "3"));
        assertEquals("II", calc.calculate("I","*", "II"));
        assertEquals("2", calc.calculate("1","*", "2"));

        assertEquals("II", calc.calculate("XII","/", "VI"));
        assertEquals("2", calc.calculate("12","/", "6"));
        assertEquals("XIX", calc.calculate("XXXVIII","/", "II"));
        assertEquals("19", calc.calculate("38","/", "2"));
    }
}