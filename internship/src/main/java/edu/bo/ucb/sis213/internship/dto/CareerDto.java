package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Career;

public class CareerDto {
    private int idCareer;
    private String nameCareer;

    public CareerDto() {
    }

    public CareerDto(int idCareer, String nameCareer, String descriptionCareer) {
        this.idCareer = idCareer;
        this.nameCareer = nameCareer;

    }

    public int getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(int idCareer) {
        this.idCareer = idCareer;
    }

    public String getNameCareer() {
        return nameCareer;
    }

    public void setNameCareer(String nameCareer) {
        this.nameCareer = nameCareer;
    }

    @Override
    public String toString() {
        return "CareerDto{" +
                "idCareer=" + idCareer +
                ", nameCareer='" + nameCareer + '\'' +
                '}';
    }
    public CareerDto(Career career){
        this.idCareer = career.getIdCarrer();
        this.nameCareer = career.getCareerName();
    }
    public Career toEntity(){
        return new Career(this.idCareer,this.nameCareer);
    }
}
