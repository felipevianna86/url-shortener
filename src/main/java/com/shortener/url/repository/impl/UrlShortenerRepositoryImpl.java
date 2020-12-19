package com.shortener.url.repository.impl;

import com.shortener.url.repository.UrlShortenerRepository;
import com.shortener.url.repository.UrlShortenerRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class UrlShortenerRepositoryImpl implements UrlShortenerRepositoryCustom {

    @Autowired
    private EntityManager em;

    public String getFullUrl(String randomString) throws Exception {

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT originalUrl ");
        sql.append("FROM URL u ");
        sql.append("WHERE u.shortUrl = :randomString ");

        Query q = em.createQuery(sql.toString());

        q.setParameter("randomString", randomString);

        String result  = null;

        try{
            result  = (String) q.getSingleResult();
        }catch (NoResultException e){
            throw new Exception("URL não encontrada");
        }

        return result;
    }
}
