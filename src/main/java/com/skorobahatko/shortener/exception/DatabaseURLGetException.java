package com.skorobahatko.shortener.exception;

public class DatabaseURLGetException extends DatabaseException {
    public DatabaseURLGetException() {
    }

    public DatabaseURLGetException(String message) {
        super(message);
    }

    public DatabaseURLGetException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseURLGetException(Throwable cause) {
        super(cause);
    }
}
