package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "carrer_internship")
public class CarrerInternship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrer_internship")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "internship_id_internship", referencedColumnName = "id_internship")
    private Internship internship;

    @ManyToOne
    @JoinColumn(name = "career_id_carrer", referencedColumnName = "id_carrer")
    private Career career;

    public CarrerInternship() {
    }

    public CarrerInternship(Long id, Internship internship, Career career) {
        this.id = id;
        this.internship = internship;
        this.career = career;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return "CarrerInternship{" +
                "id=" + id +
                ", internship=" + internship +
                ", career=" + career +
                '}';
    }
}