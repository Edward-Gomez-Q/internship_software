package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Internship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InternshipDto {
    private String title;
    private String department;
    private Date deadline;
    private String days;
    private int duration;
    private Date startDate;
    private Date endDate;
    private String description;
    private String urlPDF;
    private String urlWORD;
    private List<String> careers;
    private String knowledge;
    //Constructor vacio
    public InternshipDto(){

    }
    //Constructor con parametros
    public InternshipDto(String title, String department, Date deadline, String days, int duration, Date startDate, Date endDate, String description, String urlPDF, String urlWORD, List<String> careers, String knowledge) {
        this.title = title;
        this.department = department;
        this.deadline = deadline;
        this.days = days;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.urlPDF = urlPDF;
        this.urlWORD = urlWORD;
        this.careers = careers;
        this.knowledge = knowledge;
    }
    //Constructor
    public InternshipDto(Internship internship){
        this.title = internship.getTitle();
        this.department = internship.getCity();
        this.deadline = internship.getDeadline();
        this.days = internship.getDays();
        this.duration = internship.getDuration();
        this.startDate = internship.getStartTimeInternship();
        this.endDate = internship.getEndTimeInternship();
        this.description = internship.getDescription();
        this.urlPDF = internship.getUlrDescription();
        this.urlWORD = internship.getUrlSyllable();
        this.careers = new ArrayList<>();
        this.knowledge = internship.getKnowledge();
    }

    //Getters y Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPDF() {
        return urlPDF;
    }

    public void setUrlPDF(String urlPDF) {
        this.urlPDF = urlPDF;
    }

    public String getUrlWORD() {
        return urlWORD;
    }

    public void setUrlWORD(String urlWORD) {
        this.urlWORD = urlWORD;
    }

    public List<String> getCareers() {
        return careers;
    }

    public void setCareers(List<String> careers) {
        this.careers = careers;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public String toString() {
        return "InternshipDto{" +
                "title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", deadline=" + deadline +
                ", days='" + days + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", urlPDF='" + urlPDF + '\'' +
                ", urlWORD='" + urlWORD + '\'' +
                ", careers=" + careers +
                ", knowledge='" + knowledge + '\'' +
                '}';
    }
}
