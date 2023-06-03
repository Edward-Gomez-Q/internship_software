package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campus")
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campus")
    private int campusId;

    @Column(name = "campus_name", nullable = false)
    private String campusName;
    @OneToMany(mappedBy = "campus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Faculty> faculties;

    public Campus() {
        this.faculties = new ArrayList<>();
    }

    public Campus(int campusId, String campusName, List<Faculty> faculties) {
        this.campusId = campusId;
        this.campusName = campusName;
        this.faculties = faculties;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
    @Override
    public String toString() {
        return "Campus{" +
                "campusId=" + campusId +
                ", campusName='" + campusName + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}