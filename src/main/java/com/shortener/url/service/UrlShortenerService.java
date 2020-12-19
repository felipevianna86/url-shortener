package com.shortener.url.service;

import com.shortener.url.dto.RequestUrlDTO;
import com.shortener.url.dto.ResponseUrlDTO;
import com.shortener.url.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

@Service
public class UrlShortenerService {

    private final UrlShortenerRepository urlShortenerRepository;
    private final BaseConversionService baseConversionService;

    public UrlShortenerService(@Autowired UrlShortenerRepository urlShortenerRepository, @Autowired BaseConversionService baseConversionService){
        this.urlShortenerRepository = urlShortenerRepository;
        this.baseConversionService = baseConversionService;
    }

    public ResponseUrlDTO urlConverter(RequestUrlDTO requestUrlDTO) throws Exception {
        try {
            validateURL(requestUrlDTO.getUrl());
        }catch (Exception e){
            throw new Exception("URL inválida");
        }

        String shortUrl = baseConversionService.encode();

        saveShortUrl(requestUrlDTO, shortUrl);

        return ResponseUrlDTO.builder()
                .originalUrl(requestUrlDTO.getUrl())
                .shortUrl(shortUrl)
                .build();
    }

    public String getFullUrl(String randomString) throws Exception {
        return urlShortenerRepository.getFullUrl(randomString);
    }

    private void validateURL(String urlToCheck) throws MalformedURLException, URISyntaxException {

        URL url = new URL(urlToCheck);
        url.toURI();

    }

    @Transactional
    private void saveShortUrl(RequestUrlDTO requestUrlDTO, String shortUrl){

        urlShortenerRepository.save(buildClassURL(requestUrlDTO,shortUrl));

    }

    private com.shortener.url.model.URL buildClassURL(RequestUrlDTO requestUrlDTO, String shortUrl){

        return com.shortener.url.model.URL.builder()
                .shortUrl(shortUrl)
                .dateCreated(new Date())
                .originalUrl(requestUrlDTO.getUrl())
                .idUsuario(requestUrlDTO.getIdUsuario())
                .build();
    }
}
