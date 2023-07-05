package com.jk.explore.boot.boot31.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Getter
@Setter
public class DatabaseCredentials {

    @Value("${username}")
    private String username;

    @Value("${secret}")
    private String secret;

    @Value("${url}")
    private String url;


}
