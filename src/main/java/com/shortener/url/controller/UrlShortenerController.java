package com.shortener.url.controller;

import com.shortener.url.dto.RequestUrlDTO;
import com.shortener.url.dto.ResponseUrlDTO;
import com.shortener.url.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/shorturl", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity shortUrl(@RequestBody RequestUrlDTO requestUrlDTO){

        ResponseUrlDTO responseUrlDTO = new ResponseUrlDTO();
        try {
            responseUrlDTO = urlShortenerService.urlConverter(requestUrlDTO);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(responseUrlDTO, HttpStatus.OK);
    }

}
