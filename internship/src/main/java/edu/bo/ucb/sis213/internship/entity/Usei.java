package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "USEI")
public class Usei {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_USEI")
    private Long useiId;

    @ManyToOne
    @JoinColumn(name = "campus_id_campus", referencedColumnName = "id_campus")
    private Campus campus;

    @ManyToOne
    @JoinColumn(name = "person_id_person", referencedColumnName = "id_person")
    private Person person;

    public Usei() {
    }

    public Usei(Long useiId, Campus campus, Person person) {
        this.useiId = useiId;
        this.campus = campus;
        this.person = person;
    }

    public Long getUseiId() {
        return useiId;
    }

    public void setUseiId(Long useiId) {
        this.useiId = useiId;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Usei{" +
                "useiId=" + useiId +
                ", campus=" + campus +
                ", person=" + person +
                '}';
    }
}