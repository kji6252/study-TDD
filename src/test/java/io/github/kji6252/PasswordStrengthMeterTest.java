package io.github.kji6252;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PasswordStrengthMeterTest {


    @Test
    public void 테스트() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@#AB");
        assertEquals(PasswordStrength.STRONG, result);
    }

    /**
     *
     */
    @Test
    public void 테스트2() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = null;
        assertEquals(PasswordStrength.STRONG, result);
    }
}
