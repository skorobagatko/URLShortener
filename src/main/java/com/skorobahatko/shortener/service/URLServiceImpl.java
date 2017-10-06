package com.skorobahatko.shortener.service;

import com.skorobahatko.shortener.dao.URLDao;
import com.skorobahatko.shortener.model.URL;
import com.skorobahatko.shortener.exception.DatabaseException;
import com.skorobahatko.shortener.util.Base62Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class URLServiceImpl implements URLService {

    private static final String DEFAULT_DOMAIN = "domain.com";

    private String domain;

    private URLDao urlDao;

    @Override
    @Transactional
    public URL getShortenedURL(final URL url) throws DatabaseException {
        // save original url to DB and get it's ID
        long id = urlDao.save(url);
        // send ID to converter and get result in 62 base
        String base62 = Base62Converter.convertToBase62(id);
        // build result shortened URL
        String shortenedURL = domain + "/" + base62;
        return new URL(shortenedURL);
    }

    @Override
    @Transactional
    public @Nullable URL getOriginalURL(final URL shortURL) throws DatabaseException {
        // Prepare url value (get base 62 value from it)
        String base62 = truncate(shortURL.getUrl());
        // Convert base62 value to url's id in database
        Long id = Base62Converter.convertFromBase62(base62);
        // Get url from database by it's ID and return it
        return urlDao.getById(id);
    }

    private static String truncate(final String url) {
        int index = url.lastIndexOf("/") + 1;
        return url.substring(index);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setUrlDao(URLDao urlDao) {
        this.urlDao = urlDao;
    }
}