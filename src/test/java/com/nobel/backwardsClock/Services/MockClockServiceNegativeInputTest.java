package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Exceptions.AppException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MockClockServiceNegativeInputTest {

    private final ValidatorService validatorService;

    private final ClockDecreaseService clockDecreaseService;

    public MockClockServiceNegativeInputTest(ValidatorService validatorService, ClockDecreaseService clockDecreaseService) {
        this.validatorService = validatorService;
        this.clockDecreaseService = clockDecreaseService;
    }

    public void runMockClockApplication() throws IOException {

        try {
            System.out.println("Enter decrement in seconds: ");
            String inputSeconds = readInput();
            int DECREMENT_BY_SECS = validatorService.validateInput(inputSeconds);
            long currentTime = clockDecreaseService.getCurrentTimeInSeconds();

            clockDecreaseService.displayTime(currentTime);
            currentTime = clockDecreaseService.decreaseTime(currentTime,DECREMENT_BY_SECS);

        } catch (AppException e) {
            throw e;
        }

    }

    public String readInput() {
        return "-10";
    }
}
