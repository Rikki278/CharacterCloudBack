package org.example.authservice.model;

import lombok.RequiredArgsConstructor;

public class AuthenticationResponse {

    private String token;
    private String userId;

    private String username;

    private String imageUrl;

    public AuthenticationResponse(String token, String userId, String username, String imageUrl) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.imageUrl = imageUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

