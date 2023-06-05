package edu.bo.ucb.sis213.internship.dto;

public class TokenDto {
    private String authToken;
    private String refreshToken;

    public TokenDto() {
    }

    @Override
    public String toString() {
        return "{" +
                "authToken='" + authToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}