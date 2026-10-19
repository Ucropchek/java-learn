package ru.seroglazov.validation;

public class EvennessCountOfArgumentsException extends RuntimeException {
    public EvennessCountOfArgumentsException() {
        this("Передано нечетное кол-во аргументов!");
    }

    public EvennessCountOfArgumentsException(String message) {
        super(message);
    }
}
