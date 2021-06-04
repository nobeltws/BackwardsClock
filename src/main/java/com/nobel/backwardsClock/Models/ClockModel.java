package com.nobel.backwardsClock.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClockModel{
    private long hours;
    private long minutes;
    private long seconds;

    public ClockModel(long hours, long minutes, long seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}
