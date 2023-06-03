package edu.bo.ucb.sis213.internship.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "postulation")
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulation")
    private Integer idPostulation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internship_id_internship", referencedColumnName = "id_internship")
    private Internship internship;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id_student", referencedColumnName = "id_student")
    private Student student;

    @Column(name = "presentation_date", nullable = false)
    private Date presentationDate;

    @Column(name = "url_CV", nullable = false)
    private String urlCV;

    @Column(name = "state_postulation", nullable = false)
    private Integer statePostulation;

    @Column(name = "note", nullable = false)
    private String note;

    public Postulation() {
    }

    public Postulation(Integer idPostulation, Internship internship, Student student, Date presentationDate, String urlCV, Integer statePostulation, String note) {
        this.idPostulation = idPostulation;
        this.internship = internship;
        this.student = student;
        this.presentationDate = presentationDate;
        this.urlCV = urlCV;
        this.statePostulation = statePostulation;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Postulation{" +
                "idPostulation=" + idPostulation +
                ", internship=" + internship +
                ", student=" + student +
                ", presentationDate=" + presentationDate +
                ", urlCV='" + urlCV + '\'' +
                ", statePostulation=" + statePostulation +
                ", note='" + note + '\'' +
                '}';
    }

    public Integer getIdPostulation() {
        return idPostulation;
    }

    public void setIdPostulation(Integer idPostulation) {
        this.idPostulation = idPostulation;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getPresentationDate() {
        return presentationDate;
    }

    public void setPresentationDate(Date presentationDate) {
        this.presentationDate = presentationDate;
    }

    public String getUrlCV() {
        return urlCV;
    }

    public void setUrlCV(String urlCV) {
        this.urlCV = urlCV;
    }

    public Integer getStatePostulation() {
        return statePostulation;
    }

    public void setStatePostulation(Integer statePostulation) {
        this.statePostulation = statePostulation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}