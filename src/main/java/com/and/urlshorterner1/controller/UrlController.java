package com.and.urlshorterner1.controller;

import com.and.urlshorterner1.entry.Url;
import com.and.urlshorterner1.service.manager.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/urlShortener")
public class UrlController {

    @Autowired
    private UrlManager urlManager;

    @RequestMapping(value = "/{url}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity shortenUrl(@PathVariable String url) {
        Url shortUrlEntry = urlManager.shortenUrl(url);
        return ResponseEntity.ok(url);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUrl(@PathVariable String key) {
        String url = urlManager.getUrlByKey(key);
        return ResponseEntity.ok(url);
    }

    @RequestMapping(value = "/withredirect/{key}", method = RequestMethod.GET)
    @ResponseBody
    public void getUrlRedirect(@PathVariable String key, HttpServletResponse response) throws IOException {
        String url = urlManager.getUrlByKey(key);
        response.sendRedirect(url);
    }
}