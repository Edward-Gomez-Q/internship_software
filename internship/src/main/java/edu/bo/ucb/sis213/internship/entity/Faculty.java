package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;

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

    public Faculty() {
    }

    public Faculty(int facultyId, String facultyName, Campus campus) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.campus = campus;
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

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", campus=" + campus +
                '}';
    }
}