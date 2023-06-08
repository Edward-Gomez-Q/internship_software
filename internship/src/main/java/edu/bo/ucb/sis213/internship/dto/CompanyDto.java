package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Company;

import java.util.List;

public class CompanyDto {
    private String nameCompany;
    private List<String> sectors;
    private String review;
    private String urlLogo;
    private String webSide;
    private String nit;
    private String Names;
    private String firstLastName;
    private String secondLastName;
    private String email;
    private String password;
    private String phone;

    public CompanyDto(){

    }
    public CompanyDto(String nameCompany, List<String> sectors, String review, String urlLogo, String webSide, String nit, String names, String firstLastName, String secondLastName, String email, String password, String phone) {
        this.nameCompany = nameCompany;
        this.sectors = sectors;
        this.review = review;
        this.urlLogo = urlLogo;
        this.webSide = webSide;
        this.nit = nit;
        Names = names;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public CompanyDto(Company company){
        this.nameCompany = company.getNameCompany();
        this.review = company.getReview();
        this.urlLogo = company.getUrlIcon();
        this.webSide = company.getWebsite()
        this.nit = company.getNit();
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public List<String> getSectors() {
        return sectors;
    }

    public void setSectors(List<String> sectors) {
        this.sectors = sectors;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getWebSide() {
        return webSide;
    }

    public void setWebSide(String webSide) {
        this.webSide = webSide;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "nameCompany='" + nameCompany + '\'' +
                ", sectors=" + sectors +
                ", review='" + review + '\'' +
                ", urlLogo='" + urlLogo + '\'' +
                ", webSide='" + webSide + '\'' +
                ", nit='" + nit + '\'' +
                ", Names='" + Names + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    //Constructor para convertir de dto a entity

}
