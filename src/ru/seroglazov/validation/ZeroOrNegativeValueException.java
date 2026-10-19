package ru.seroglazov.validation;

public class ZeroOrNegativeValueException extends RuntimeException {
    public ZeroOrNegativeValueException(String message) {
        super(message);
    }
}
