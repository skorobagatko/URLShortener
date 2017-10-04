package com.skorobahatko.shortener.controller;

import com.skorobahatko.shortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class URLShortenerController {

    private URLService urlService;

    @Autowired(required = true)
    @Qualifier(value = "urlService")
    public void setUrlService(URLService urlService) {
        this.urlService = urlService;
    }
}
