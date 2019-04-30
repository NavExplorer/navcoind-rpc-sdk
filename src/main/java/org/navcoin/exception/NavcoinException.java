package org.navcoin.exception;

public class NavcoinException extends RuntimeException {
    public NavcoinException() {
    }

    public NavcoinException(String message) {
        super(message);
    }

    public NavcoinException(String message, Throwable cause) {
        super(message, cause);
    }
}
