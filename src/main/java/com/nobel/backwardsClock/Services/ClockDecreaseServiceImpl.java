package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Configs.Keys.ClockProperties;
import com.nobel.backwardsClock.Models.ClockModel;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.nobel.backwardsClock.Utils.ClockUtil.*;
import static com.nobel.backwardsClock.Utils.Constants.DAY_IN_SECONDS;

@Service
public class ClockDecreaseServiceImpl implements ClockDecreaseService {

    ClockProperties clockProperties;

    public ClockDecreaseServiceImpl(ClockProperties clockProperties) {
        this.clockProperties = clockProperties;
    }

    @Override
    public long getCurrentTimeInSeconds() {
        LocalDateTime date = LocalDateTime.now(ZoneId.of(clockProperties.getZoneId()));
        long currentTimeInSeconds = Duration.between(date.withSecond(0).withMinute(0).withHour(0), date).getSeconds();
        return currentTimeInSeconds;
    }

    @Override
    public void displayTime(long currentTimeInSeconds) {
        ClockModel clockModel = new ClockModel(calcHours(currentTimeInSeconds),
                calcMinutes(currentTimeInSeconds),
                calcSeconds(currentTimeInSeconds));
        System.out.print(formatClockTime(clockModel));
        pause(1000);
    }

    @Override
    public long decreaseTime(long currentTimeInSeconds, int decreaseSeconds) {
        currentTimeInSeconds = currentTimeInSeconds - decreaseSeconds;
        if (currentTimeInSeconds < 0) {
            currentTimeInSeconds = currentTimeInSeconds + DAY_IN_SECONDS;
        }
        return currentTimeInSeconds;
    }

    private String formatClockTime(ClockModel clockModel) {
        return String.format("%02d:%02d:%02d\r",
                clockModel.getHours(),
                clockModel.getMinutes(),
                clockModel.getSeconds());
    }

    private void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
