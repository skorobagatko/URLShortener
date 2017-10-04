package com.skorobahatko.shortener.service;

import com.skorobahatko.shortener.model.URL;
import com.skorobahatko.shortener.exception.DatabaseException;

public interface URLService {

    URL getShortenedURL(URL url) throws DatabaseException;
    URL getOriginalURL(URL url) throws DatabaseException;

}
