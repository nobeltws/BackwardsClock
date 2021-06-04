package com.nobel.backwardsClock.Services;

public interface ClockDecreaseService {
    long getCurrentTimeInSeconds();
    void displayTime(long currentTimeInSeconds);
    long decreaseTime(long currentTimeInSeconds, int decreaseSeconds);
}
