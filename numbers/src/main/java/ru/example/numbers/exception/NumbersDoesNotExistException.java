package ru.example.numbers.exception;

public class NumbersDoesNotExistException extends RuntimeException {
    public NumbersDoesNotExistException(final String message) {
        super(message);
    }
}