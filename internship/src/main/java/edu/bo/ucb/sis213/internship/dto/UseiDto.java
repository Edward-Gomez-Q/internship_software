package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Usei;

public class UseiDto {
    private Integer idUsei;
    private String names;
    private String firstLastName;
    private String secondLastName;
    private String campus;

    public UseiDto () {

    }
    public UseiDto(Integer idUsei, String names, String firstLastName, String secondLastName, String campus) {
        this.idUsei = idUsei;
        this.names = names;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.campus = campus;
    }

    public UseiDto(Usei usei){
        this.idUsei = usei.getIdUsei();
        this.names = usei.getPersonIdPerson().getNames();
        this.firstLastName = usei.getPersonIdPerson().getFirstLastName();
        this.secondLastName = usei.getPersonIdPerson().getSecondLastName();
        this.campus = usei.getCampusIdCampus().getCampusName();
    }

    public Integer getIdUsei() {
        return idUsei;
    }

    public void setIdUsei(Integer idUsei) {
        this.idUsei = idUsei;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "UseiDto{" +
                "idUsei=" + idUsei +
                ", names='" + names + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", campus='" + campus + '\'' +
                '}';
    }
}
