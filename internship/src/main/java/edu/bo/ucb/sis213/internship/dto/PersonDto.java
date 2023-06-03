package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Person;

public class PersonDto {
    private int id_person;
    private String names;
    private String first_last_name;
    private String second_last_name;
    //Constructor
    public PersonDto() {
    }
    public PersonDto(int id_person, String names, String first_last_name, String second_last_name) {
        this.id_person = id_person;
        this.names = names;
        this.first_last_name = first_last_name;
        this.second_last_name = second_last_name;
    }
    public PersonDto(Person person){
        this.id_person = person.getPersonId();
        this.names = person.getNames();
        this.first_last_name = person.getFirstLastName();
        this.second_last_name = person.getSecondLastName();
    }
    //Funcion para convertir de PersonDto a Person
    public Person toPerson(){
        Person person = new Person();
        person.setPersonId(this.id_person);
        person.setNames(this.names);
        person.setFirstLastName(this.first_last_name);
        person.setSecondLastName(this.second_last_name);
        return person;
    }
    //Getters and Setters
    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFirst_last_name() {
        return first_last_name;
    }

    public void setFirst_last_name(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id_person=" + id_person +
                ", names='" + names + '\'' +
                ", first_last_name='" + first_last_name + '\'' +
                ", second_last_name='" + second_last_name + '\'' +
                '}';
    }
}
