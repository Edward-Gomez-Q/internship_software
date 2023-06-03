package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Faculty;

import java.util.List;

public class FacultyDto {
    private int id_faculty;
    private String name;
    private List<CareerDto> careers;
    //Constructor
    public FacultyDto() {
    }
    //Constructor
    public FacultyDto(int id_faculty, String name, List<CareerDto> careers) {
        this.id_faculty = id_faculty;
        this.name = name;
        this.careers = careers;
    }
    //Getters and Setters
    public int getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(int id_faculty) {
        this.id_faculty = id_faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CareerDto> getCareers() {
        return careers;
    }

    public void setCareers(List<CareerDto> careers) {
        this.careers = careers;
    }
    //Funcion para convertir de FacultyDto a Faculty
    public Faculty toFaculty(){
        Faculty faculty = new Faculty();
        faculty.setFacultyId(this.id_faculty);
        faculty.setFacultyName(this.name);
        return faculty;
    }
    //toString

    @Override
    public String toString() {
        return "FacultyDto{" +
                "id_faculty=" + id_faculty +
                ", name='" + name + '\'' +
                ", careers=" + careers +
                '}';
    }
}
