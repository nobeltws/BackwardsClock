package com.nobel.backwardsClock.Configs.Keys;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "clock")
@Data
public class ClockProperties {
    private String zoneId;
}
