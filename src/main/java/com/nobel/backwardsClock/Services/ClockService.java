package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Exceptions.AppException;
import com.nobel.backwardsClock.Threads.InterruptThread;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ClockService {

    private final ValidatorService validatorService;

    private final ClockDecreaseService clockDecreaseService;

    public ClockService(ValidatorService validatorService, ClockDecreaseService clockDecreaseService) {
        this.validatorService = validatorService;
        this.clockDecreaseService = clockDecreaseService;
    }

    public void runClockApplication() throws IOException {
        while (true) {
            try {
                System.out.println("Enter decrement in seconds: ");
                String inputSeconds = readInput();
                int DECREMENT_BY_SECS = validatorService.validateInput(inputSeconds);
                InterruptThread endClockThread = new InterruptThread();
                endClockThread.start();
                long currentTime = clockDecreaseService.getCurrentTimeInSeconds();

                while (endClockThread.isAlive()) {
                    clockDecreaseService.displayTime(currentTime);
                    currentTime = clockDecreaseService.decreaseTime(currentTime,DECREMENT_BY_SECS);
                }


            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputSeconds;
        try {
            inputSeconds = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return inputSeconds;
    }
}
