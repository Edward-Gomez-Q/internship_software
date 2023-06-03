package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Career;

import java.util.List;

public class CareerDto {
    private int id_career;
    private String career_name;



    public CareerDto() {
    }
    //Constructor
    public CareerDto(int id_career, String name) {
        this.id_career = id_career;
        this.career_name = name;
    }
    //Constructor
    public CareerDto(Career career){
        this.id_career = career.getCareerId();
        this.career_name = career.getCareerName();
    }
    //Funcion para convertir de CareerDto a Career
    public Career toCareer(){
        Career career = new Career();
        career.setCareerId(this.id_career);
        career.setCareerName(this.career_name);
        return career;
    }
    @Override
    public String toString() {
        return "CareerDto{" +
                "id_career=" + id_career +
                ", career_name='" + career_name + '\'' +
                '}';
    }

    public int getId_career() {
        return id_career;
    }

    public void setId_career(int id_career) {
        this.id_career = id_career;
    }

    public String getCareer_name() {
        return career_name;
    }

    public void setCareer_name(String career_name) {
        this.career_name = career_name;
    }
}
