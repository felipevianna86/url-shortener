package com.shortener.url.repository;

import com.shortener.url.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortenerRepository extends JpaRepository<URL, Long>, UrlShortenerRepositoryCustom {
}
