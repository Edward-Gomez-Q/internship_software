package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "approve_company")
public class ApproveCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_approve_company")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USEI_id_USEI", referencedColumnName = "id_USEI")
    private Usei usei;

    @ManyToOne
    @JoinColumn(name = "company_id_company", referencedColumnName = "id_company")
    private Company company;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "approve", nullable = false)
    private Boolean approve;

    public ApproveCompany() {
    }

    public ApproveCompany(int id, Usei usei, Company company, Date date, Boolean approve) {
        this.id = id;
        this.usei = usei;
        this.company = company;
        this.date = date;
        this.approve = approve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usei getUsei() {
        return usei;
    }

    public void setUsei(Usei usei) {
        this.usei = usei;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        return "ApproveCompany{" +
                "id=" + id +
                ", usei=" + usei +
                ", company=" + company +
                ", date=" + date +
                ", approve=" + approve +
                '}';
    }
}
