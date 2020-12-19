package com.shortener.url.service;

import org.springframework.stereotype.Service;

@Service
public class BaseConversionService {

    private static final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowedCharacters = allowedString.toCharArray();
    private int base = allowedCharacters.length;

    public String encode(){
        StringBuilder encodedString = new StringBuilder();

        for(int i = 0; i < 5; i++){
            encodedString.append(allowedString.charAt( (int) Math.floor(Math.random() * allowedString.length())));
        }
        return encodedString.toString();
    }


}
