package com.nobel.backwardsClock.Utils;

import com.nobel.backwardsClock.Exceptions.NegativeIntegerException;

public class ClockUtil {

    public static long calcHours(long seconds) {
        if (seconds < 0){
            throw new NegativeIntegerException("Input is negative");
        }
        return seconds / 3600;
    }

    public static long calcMinutes(long seconds) {
        if (seconds < 0){
            throw new NegativeIntegerException("Input is negative");
        }
        return ((seconds % 3600) / 60);
    }

    public static long calcSeconds(long seconds) {
        if (seconds < 0){
            throw new NegativeIntegerException("Input is negative");
        }
        return seconds % 60;
    }
}
