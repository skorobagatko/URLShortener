package com.skorobahatko.shortener.controller;

import com.skorobahatko.shortener.exception.DatabaseException;
import com.skorobahatko.shortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView getShortenedUrl(@RequestParam("url") String url) {
        try {
            String shortURL = urlService.getShortenedURL(url);
            System.out.println(shortURL);
            ModelAndView mav = new ModelAndView();
            mav.addObject("shortUrl", shortURL);
            mav.setViewName("index");
            mav.setStatus(HttpStatus.OK);
            return mav;
        } catch (DatabaseException e) {
            //TODO: redirect to main page and print some error message
            e.printStackTrace();
            return new ModelAndView("index");
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
