package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.User;

public class UserDto {
    private int idUser;
    private PersonDto personDto;
    private String mail;
    private String password;
    //Builder
    public UserDto() {
    }
    //Builder
    public UserDto(int idUser, PersonDto personDto, String mail, String password) {
        this.idUser = idUser;
        this.personDto = personDto;
        this.mail = mail;
        this.password = password;
    }
    public UserDto(User user){
        this.idUser = user.getId();
        this.personDto = new PersonDto(user.getPerson());
        this.mail = user.getMail();
        this.password = user.getPassword();
    }
    //Funcion para convertir de UserDto a User
    public User toUser(){
        User user = new User();
        user.setId(this.idUser);
        user.setPerson(this.personDto.toPerson());
        user.setMail(this.mail);
        user.setPassword(this.password);
        return user;
    }
    //Getters and Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
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
    //ToString

    @Override
    public String toString() {
        return "UserDto{" +
                "idUser=" + idUser +
                ", personDto=" + personDto +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
