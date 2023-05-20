package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "career")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrer")
    private Long careerId;

    @Column(name = "career_name", nullable = false)
    private String careerName;

    @ManyToOne
    @JoinColumn(name = "faculty_id_faculty", referencedColumnName = "id_faculty")
    private Faculty faculty;

    public Career() {
    }

    public Career(Long careerId, String careerName, Faculty faculty) {
        this.careerId = careerId;
        this.careerName = careerName;
        this.faculty = faculty;
    }

    public Long getCareerId() {
        return careerId;
    }

    public void setCareerId(Long careerId) {
        this.careerId = careerId;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Career{" +
                "careerId=" + careerId +
                ", careerName='" + careerName + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}