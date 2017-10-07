package com.skorobahatko.shortener.service;

import com.skorobahatko.shortener.model.URL;
import com.skorobahatko.shortener.exception.DatabaseException;

public interface URLService {

    String getShortenedURL(String originalURL) throws DatabaseException;
    String getOriginalURL(String shortURL) throws DatabaseException;

}
