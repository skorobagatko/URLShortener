package com.skorobahatko.shortener.controller;

import com.skorobahatko.shortener.exception.DatabaseException;
import com.skorobahatko.shortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class URLShortenerController {

    private URLService urlService;

    @Autowired(required = true)
    @Qualifier(value = "urlService")
    public void setUrlService(URLService urlService) {
        this.urlService = urlService;
    }

    @RequestMapping(value = "/short", method = RequestMethod.POST)
    public String getShortenedUrl(@RequestParam("url") String url) {
        try {
            String shortURL = urlService.getShortenedURL(url);
            System.out.println(shortURL);
            return "index";
        } catch (DatabaseException e) {
            //TODO: redirect to main page and print some error message
            e.printStackTrace();
            return "index";
        }
    }

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public String getOriginalUrl(@PathVariable String shortUrl) {
        try {
            String originalURL = urlService.getOriginalURL(shortUrl);
            return "redirect:" + originalURL;
        } catch (DatabaseException e) {
            //TODO: redirect to main page and print some error message
            e.printStackTrace();
            return "index";
        }
    }
}
