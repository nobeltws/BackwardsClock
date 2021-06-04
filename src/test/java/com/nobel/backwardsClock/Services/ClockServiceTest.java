package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Exceptions.AppException;
import com.nobel.backwardsClock.Exceptions.NegativeIntegerException;
import com.nobel.backwardsClock.Exceptions.NonIntegerException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClockServiceTest {

    private MockClockServiceSuccessTest mockClockServiceSuccessTest;

    private MockClockServiceNegativeInputTest mockClockServiceNegativeInputTest;

    private MockClockServiceStringInputTest mockClockServiceStringInputTest;

    @Test
    public void runMockClockApplicationSuccessTest() throws IOException{
        ClockDecreaseService clockDecreaseService = Mockito.mock(ClockDecreaseService.class);
        Mockito.when(clockDecreaseService.getCurrentTimeInSeconds()).thenReturn(36000L);
        ValidatorService validatorService = Mockito.mock(ValidatorService.class);
        Mockito.when(validatorService.validateInput(Mockito.anyString())).thenReturn(1);
        mockClockServiceSuccessTest = new MockClockServiceSuccessTest(validatorService, clockDecreaseService);

        mockClockServiceSuccessTest.runMockClockApplication();
    }

    @Test
    public void runMockClockApplicationNegativeInputTest() {
        ClockDecreaseService clockDecreaseService = Mockito.mock(ClockDecreaseService.class);
        Mockito.when(clockDecreaseService.getCurrentTimeInSeconds()).thenReturn(36000L);
        ValidatorService validatorService = Mockito.mock(ValidatorService.class);
        Mockito.when(validatorService.validateInput("-10")).thenThrow(NegativeIntegerException.class);
        mockClockServiceNegativeInputTest = new MockClockServiceNegativeInputTest(validatorService, clockDecreaseService);

        assertThrows(AppException.class, () -> {
            mockClockServiceNegativeInputTest.runMockClockApplication();
        });
    }

    @Test
    public void runMockClockApplicationStringInputTest() {
        ClockDecreaseService clockDecreaseService = Mockito.mock(ClockDecreaseService.class);
        Mockito.when(clockDecreaseService.getCurrentTimeInSeconds()).thenReturn(36000L);
        ValidatorService validatorService = Mockito.mock(ValidatorService.class);
        Mockito.when(validatorService.validateInput("abc")).thenThrow(NonIntegerException.class);
        mockClockServiceStringInputTest = new MockClockServiceStringInputTest(validatorService, clockDecreaseService);

        assertThrows(AppException.class, () -> {
            mockClockServiceStringInputTest.runMockClockApplication();
        });
    }
}
