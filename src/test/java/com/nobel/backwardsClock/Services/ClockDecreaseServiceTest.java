package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Configs.Keys.ClockProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockDecreaseServiceTest {

    private ClockDecreaseServiceImpl clockDecreaseService;

    @BeforeEach
    public void init() {
        ClockProperties clockProperties = new ClockProperties();
        clockProperties.setZoneId("Asia/Singapore");
        clockDecreaseService = new ClockDecreaseServiceImpl(clockProperties);
    }

    @Test
    public void getCurrentTimeInSecondsTest() {
        long actualReturn = clockDecreaseService.getCurrentTimeInSeconds();
    }

    @Test
    public void displayTimeTest() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        long testInput = 36000;
        String expectedOutput = "10:00:00";
        clockDecreaseService.displayTime(testInput);
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }

    @Test
    public void decreaseTimeTest() {
        long currentTime = 10;
        int decreaseBy = 1;
        long expectedOutput = 9;
        long actualOutput = clockDecreaseService.decreaseTime(currentTime, decreaseBy);
        assertEquals(actualOutput, expectedOutput);
    }

}
