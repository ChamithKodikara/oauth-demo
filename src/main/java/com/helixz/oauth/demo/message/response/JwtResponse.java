package com.helixz.oauth.demo.message.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";

    public JwtResponse(String value) {
        this.token = value;
    }
}