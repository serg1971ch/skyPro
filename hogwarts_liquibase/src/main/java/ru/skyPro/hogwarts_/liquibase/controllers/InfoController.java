package ru.skyPro.hogwarts_.liquibase.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/port")
    public String getPort() {
        return String.valueOf(port);
    }
}
