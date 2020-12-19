package com.shortener.url.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUrlDTO {

    private String shortUrl;
    private String originalUrl;

}
