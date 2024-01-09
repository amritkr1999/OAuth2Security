package com.example.OAuth2Security.Config;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class JwtAuthRequest {

    private String email;
    private String password;

    public JwtAuthRequest(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
