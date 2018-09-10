package com.example.integrations.studentregistration.utils.exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message, Throwable t) {
        super(message, t);
    }

    public DuplicateUserException(String message) {
        super(message);
    }
}
