package com.helixz.oauth.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chamith
 */
@RestController
public class DemoController {

    @GetMapping("${app.endpoint.index}")
    public String index() {
        return "Hello";
    }

    @GetMapping("${app.endpoint.testEndpoint}")
    public String testAuth() {
        return "Auth Success";
    }
}
