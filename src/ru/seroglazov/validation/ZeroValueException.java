package ru.seroglazov.validation;

public class ZeroValueException extends RuntimeException {
    public ZeroValueException(String message) {
        super(message);
    }
}
