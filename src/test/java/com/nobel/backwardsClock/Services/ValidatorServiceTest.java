package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Exceptions.NegativeIntegerException;
import com.nobel.backwardsClock.Exceptions.NoInputException;
import com.nobel.backwardsClock.Exceptions.NonIntegerException;
import com.nobel.backwardsClock.Exceptions.OutOfRangException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorServiceTest {
    private ValidatorServiceImpl validatorService;

    @BeforeEach
    public void init() {
        validatorService = new ValidatorServiceImpl();
    }

    @Test
    public void validateInputSuccessTest() {
        String testInput = "1";
        int actualReturn = validatorService.validateInput(testInput);
        assertEquals(testInput, String.valueOf(actualReturn));
    }

    @Test
    public void validateInputOutOfRangeTest() {
        String testInput = "87000";
        assertThrows(OutOfRangException.class, () -> {
            validatorService.validateInput(testInput);
        });
    }

    @Test
    public void validateInputExceedIntTest() {
        String testInput = "9999999999999";
        assertThrows(NonIntegerException.class, () -> {
            validatorService.validateInput(testInput);
        });
    }

    @Test
    public void validateInputNonIntTest() {
        String testInput = "1.1";
        assertThrows(NonIntegerException.class, () -> {
            validatorService.validateInput(testInput);
        });
    }

    @Test
    public void validateInputNegativeIntTest() {
        String testInput = "-1";
        assertThrows(NegativeIntegerException.class, () -> {
            validatorService.validateInput(testInput);
        });
    }

    @Test
    public void validateInputAlphabetsTest() {
        String testInput = "abc";
        assertThrows(NonIntegerException.class, () -> {
            validatorService.validateInput(testInput);
        });
    }

    @Test
    public void validateInputSymbolsTest() {
        String testInput = "#$%";
        assertThrows(NonIntegerException.class, () -> {
            validatorService.validateInput(testInput);
        });
    }

    @Test
    public void validateInputNullTest() {
        String testInput = null;
        assertThrows(NoInputException.class, () -> {
            validatorService.validateInput(testInput);
        });
    }
}
