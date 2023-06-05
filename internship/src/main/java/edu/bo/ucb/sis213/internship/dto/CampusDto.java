package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Campus;

public class CampusDto {
    private int idUniversity;
    private String nameUniversity;

    public CampusDto() {
    }

    public CampusDto(int idUniversity, String nameUniversity) {
        this.idUniversity = idUniversity;
        this.nameUniversity = nameUniversity;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    @Override
    public String toString() {
        return "UniversityDto{" +
                "idUniversity=" + idUniversity +
                ", nameUniversity='" + nameUniversity + '\'' +
                '}';
    }
    //Funcion para convertir de dto a entity
    public Campus toEntity(){
        return new Campus(this.idUniversity,this.nameUniversity);
    }
    //Constructor para convertir de dto a entity
    public CampusDto(Campus campus){
        this.idUniversity = campus.getIdCampus();
        this.nameUniversity = campus.getCampusName();
    }
}
