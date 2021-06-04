package com.nobel.backwardsClock.Configs;

import com.nobel.backwardsClock.Configs.Keys.ClockProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ClockProperties.class)
@Slf4j
public class PropertiesConfig {

    @Autowired
    ClockProperties clockProperties;

    public void displayProperties(ClockProperties clockProperties) {
        log.debug("Zone Id is: %s", clockProperties.getZoneId());
    }
}
