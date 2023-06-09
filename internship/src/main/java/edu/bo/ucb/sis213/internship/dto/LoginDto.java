package edu.bo.ucb.sis213.internship.dto;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto() {
    }

    public LoginDto(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                " username='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }
}
