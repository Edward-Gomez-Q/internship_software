package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faculty")
    private int facultyId;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    @ManyToOne
    @JoinColumn(name = "campus_id_campus", referencedColumnName = "id_campus")
    private Campus campus;
    @OneToMany(mappedBy = "faculty",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Career> careers;
    public Faculty() {
        this.careers = new ArrayList<>();
    }

    public Faculty(int facultyId, String facultyName, Campus campus, List<Career> carrers) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.campus = campus;
        this.careers = carrers;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Career> getCareers() {
        return careers;
    }

    public void setCareers(List<Career> careers) {
        this.careers = careers;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", campus=" + campus +
                ", careers=" + careers +
                '}';
    }
}