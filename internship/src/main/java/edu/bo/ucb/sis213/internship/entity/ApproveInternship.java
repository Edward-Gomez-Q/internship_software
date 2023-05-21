package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "approve_internship")
public class ApproveInternship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_approve_internship")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USEI_id_USEI", referencedColumnName = "id_USEI")
    private Usei usei;

    @ManyToOne
    @JoinColumn(name = "internship_id_internship", referencedColumnName = "id_internship")
    private Internship internship;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "approve", nullable = false)
    private Boolean approve;

    public ApproveInternship() {
    }

    public ApproveInternship(Long id, Usei usei, Internship internship, Date date, Boolean approve) {
        this.id = id;
        this.usei = usei;
        this.internship = internship;
        this.date = date;
        this.approve = approve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usei getUsei() {
        return usei;
    }

    public void setUsei(Usei usei) {
        this.usei = usei;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    @Override
    public String toString() {
        return "ApproveInternship{" +
                "id=" + id +
                ", usei=" + usei +
                ", internship=" + internship +
                ", date=" + date +
                ", approve=" + approve +
                '}';
    }
}
