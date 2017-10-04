package com.skorobahatko.shortener.exception;

public class DatabaseURLSaveException extends DatabaseException {
    public DatabaseURLSaveException() {
    }

    public DatabaseURLSaveException(String message) {
        super(message);
    }

    public DatabaseURLSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseURLSaveException(Throwable cause) {
        super(cause);
    }
}
