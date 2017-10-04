package com.skorobahatko.shortener.dao;

import com.skorobahatko.shortener.exception.DatabaseURLGetException;
import com.skorobahatko.shortener.exception.DatabaseURLSaveException;
import com.skorobahatko.shortener.model.URL;
import com.skorobahatko.shortener.exception.DatabaseException;

public interface URLDao {

    long save(URL url) throws DatabaseURLSaveException;
    URL getById(long id) throws DatabaseURLGetException;

}
