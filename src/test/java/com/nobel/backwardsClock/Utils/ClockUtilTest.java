package com.nobel.backwardsClock.Utils;

import com.nobel.backwardsClock.Exceptions.NegativeIntegerException;
import com.nobel.backwardsClock.Exceptions.OutOfRangException;
import org.junit.jupiter.api.Test;

import static com.nobel.backwardsClock.Utils.ClockUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClockUtilTest {

    @Test
    public void calcHoursSuccessTest() {
        long testInput = 3600;
        long expectedOutput = 1;
        assertEquals(expectedOutput, calcHours(testInput));
    }

    @Test
    public void calcHoursNegativeInputTest() {
        long testInput = -3600;
        assertThrows(NegativeIntegerException.class, () -> {
            calcHours(testInput);
        });
    }

    @Test
    public void calcMinutesSuccessTest() {
        long testInput = 60;
        long expectedOutput = 1;
        assertEquals(expectedOutput, calcMinutes(testInput));
    }

    @Test
    public void calcMinutesNegativeInputTest() {
        long testInput = -60;
        assertThrows(NegativeIntegerException.class, () -> {
            calcMinutes(testInput);
        });
    }

    @Test
    public void calcSecondsSuccessTest() {
        long testInput = 60;
        long expectedOutput = 0;
        assertEquals(expectedOutput, calcSeconds(testInput));
    }

    @Test
    public void calcSecondsNegativeInputTest() {
        long testInput = -60;
        assertThrows(NegativeIntegerException.class, () -> {
            calcSeconds(testInput);
        });
    }

}
