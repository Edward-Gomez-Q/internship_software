/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "approve_internship")
@NamedQueries({
    @NamedQuery(name = "ApproveInternship.findAll", query = "SELECT a FROM ApproveInternship a"),
    @NamedQuery(name = "ApproveInternship.findByIdApproveInternship", query = "SELECT a FROM ApproveInternship a WHERE a.idApproveInternship = :idApproveInternship"),
    @NamedQuery(name = "ApproveInternship.findByApproveInternshipDate", query = "SELECT a FROM ApproveInternship a WHERE a.approveInternshipDate = :approveInternshipDate"),
    @NamedQuery(name = "ApproveInternship.findByAprprove", query = "SELECT a FROM ApproveInternship a WHERE a.aprprove = :aprprove")})
public class ApproveInternship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_approve_internship")
    private Integer idApproveInternship;
    @Basic(optional = false)
    @Column(name = "approve_internship_date")
    @Temporal(TemporalType.DATE)
    private Date approveInternshipDate;
    @Basic(optional = false)
    @Column(name = "aprprove")
    private boolean aprprove;
    @JoinColumn(name = "internship_id_internship", referencedColumnName = "id_internship")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Internship internshipIdInternship;
    @JoinColumn(name = "usei_id_usei", referencedColumnName = "id_usei")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usei useiIdUsei;

    public ApproveInternship() {
    }

    public ApproveInternship(Integer idApproveInternship) {
        this.idApproveInternship = idApproveInternship;
    }

    public ApproveInternship(Integer idApproveInternship, Date approveInternshipDate, boolean aprprove) {
        this.idApproveInternship = idApproveInternship;
        this.approveInternshipDate = approveInternshipDate;
        this.aprprove = aprprove;
    }

    public Integer getIdApproveInternship() {
        return idApproveInternship;
    }

    public void setIdApproveInternship(Integer idApproveInternship) {
        this.idApproveInternship = idApproveInternship;
    }

    public Date getApproveInternshipDate() {
        return approveInternshipDate;
    }

    public void setApproveInternshipDate(Date approveInternshipDate) {
        this.approveInternshipDate = approveInternshipDate;
    }

    public boolean getAprprove() {
        return aprprove;
    }

    public void setAprprove(boolean aprprove) {
        this.aprprove = aprprove;
    }

    public Internship getInternshipIdInternship() {
        return internshipIdInternship;
    }

    public void setInternshipIdInternship(Internship internshipIdInternship) {
        this.internshipIdInternship = internshipIdInternship;
    }

    public Usei getUseiIdUsei() {
        return useiIdUsei;
    }

    public void setUseiIdUsei(Usei useiIdUsei) {
        this.useiIdUsei = useiIdUsei;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApproveInternship != null ? idApproveInternship.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApproveInternship)) {
            return false;
        }
        ApproveInternship other = (ApproveInternship) object;
        if ((this.idApproveInternship == null && other.idApproveInternship != null) || (this.idApproveInternship != null && !this.idApproveInternship.equals(other.idApproveInternship))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.ApproveInternship[ idApproveInternship=" + idApproveInternship + " ]";
    }
    
}
