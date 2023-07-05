package com.jk.explore.boot.boot31.properties;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Properties1Controller {

    @Resource
    private DatabaseCredentials databaseCredentials;

    @GetMapping("/rest/v1/database/credentials")
    public DatabaseCredentials getDatabaseCredentials() {
        return databaseCredentials;
    }
}
