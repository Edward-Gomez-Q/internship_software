package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Campus;

import java.util.List;

public class CampusDto {
    private int id_campus;
    private String campusName;
    private List<FacultyDto> faculties;
    //Constructor
    public CampusDto() {
    }
    //Constructor
    public CampusDto(int id_campus, String campusName, List<FacultyDto> faculties) {
        this.id_campus = id_campus;
        this.campusName = campusName;
        this.faculties = faculties;
    }
    public CampusDto(Campus campus){
        this.id_campus = campus.getCampusId();
        this.campusName = campus.getCampusName();
        this.faculties = null;
    }
    //Getters and Setters
    public int getId_campus() {
        return id_campus;
    }

    public void setId_campus(int id_campus) {
        this.id_campus = id_campus;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public List<FacultyDto> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<FacultyDto> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "CampusDto{" +
                "id_campus=" + id_campus +
                ", campusName='" + campusName + '\'' +
                ", faculties=" + faculties +
                '}';
    }
    //Funcion para convertir de CampusDto a Campus
    public Campus toCampus(){
        Campus campus = new Campus();
        campus.setCampusId(this.id_campus);
        campus.setCampusName(this.campusName);
        return campus;
    }
}
