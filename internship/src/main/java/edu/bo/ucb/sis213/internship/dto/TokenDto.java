package edu.bo.ucb.sis213.internship.dto;

public class TokenDto {
    private String authToken;
    private String refreshToken;
    private int type;
    private int id;


    public TokenDto() {
    }

    @Override
    public String toString() {
        return "{" +
                "authToken='" + authToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}