package com.shortener.url.controller;

import com.shortener.url.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class FullUrlController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @RequestMapping(method = RequestMethod.GET, value = "/u/{randomString}")
    public void getFullUrl(HttpServletResponse response, @PathVariable("randomString") String randomString) throws Exception {

        response.sendRedirect(urlShortenerService.getFullUrl(randomString));
    }
}