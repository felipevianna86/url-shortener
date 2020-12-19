package com.shortener.url.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "url")
@Builder
public class URL implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String originalUrl;

    private String shortUrl;

    private Long idUsuario;

    private Date dateCreated;

}
