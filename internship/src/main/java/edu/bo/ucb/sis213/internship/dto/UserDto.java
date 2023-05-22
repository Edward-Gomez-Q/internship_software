package edu.bo.ucb.sis213.internship.dto;

public class UserDto {
    private int id_person;
    private String mail;
    private String password;

    public UserDto() {
    }
    //Constructor
    public UserDto(int id_person, String mail, String password) {
        this.id_person = id_person;
        this.mail = mail;
        this.password = password;
    }
    //Getters and Setters

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
