package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Exceptions.AppException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class MockClockServiceSuccessTest {

    private final ValidatorService validatorService;

    private final ClockDecreaseService clockDecreaseService;

    public MockClockServiceSuccessTest(ValidatorService validatorService, ClockDecreaseService clockDecreaseService) {
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
            System.out.println(e.getMessage());
        }

    }

    public String readInput() throws IOException {
        InputStream stream = new ByteArrayInputStream("1".getBytes(StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String inputSeconds;
        try {
            inputSeconds = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return inputSeconds;
    }
}
