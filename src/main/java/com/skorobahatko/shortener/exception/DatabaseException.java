package com.skorobahatko.shortener.exception;

public class DatabaseException extends URLShortenerException {

    public DatabaseException() {}

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
