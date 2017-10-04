package com.skorobahatko.shortener.exception;

public class URLShortenerException extends Exception {

    public URLShortenerException() {}

    public URLShortenerException(String message) {
        super(message);
    }

    public URLShortenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public URLShortenerException(Throwable cause) {
        super(cause);
    }
}
