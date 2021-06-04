package com.nobel.backwardsClock.Services;

import com.nobel.backwardsClock.Exceptions.*;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public int validateInput(String input) {
        validateInputsNull(input);
        int inputSeconds = parseInteger(input);
        validatePositive(inputSeconds);
        validateZero(inputSeconds);
        validateRange(inputSeconds);
        return inputSeconds;
    }

    private void validateInputsNull(String inputs) {
        if (inputs == null) {
            throw new NoInputException("No inputs given");
        }
    }

    private void validatePositive(int input) {
        if (input < 0) {
            throw new NegativeIntegerException("Invalid input, please enter a positive integer");
        }
    }

    private void validateZero(int input) {
        if (input == 0) {
            throw new ZeroException("Invalid input, please do not enter 0");
        }
    }

    private void validateRange(int input) {
        if (input >= 86400) {
            throw new OutOfRangException("Invalid input, enter a positive integer below 86400");
        }
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NonIntegerException("Invalid input, please enter an integer");
        }
    }
}
