package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "campus")
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campus")
    private int campusId;

    @Column(name = "campus_name", nullable = false)
    private String campusName;

    public Campus() {
    }

    public Campus(int campusId, String campusName) {
        this.campusId = campusId;
        this.campusName = campusName;
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

    @Override
    public String toString() {
        return "Campus{" +
                "campusId=" + campusId +
                ", campusName='" + campusName + '\'' +
                '}';
    }
}