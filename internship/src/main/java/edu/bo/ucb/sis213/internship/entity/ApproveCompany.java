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
@Table(name = "approve_company")
@NamedQueries({
    @NamedQuery(name = "ApproveCompany.findAll", query = "SELECT a FROM ApproveCompany a"),
    @NamedQuery(name = "ApproveCompany.findByIdApproveCompany", query = "SELECT a FROM ApproveCompany a WHERE a.idApproveCompany = :idApproveCompany"),
    @NamedQuery(name = "ApproveCompany.findByApproveCompanyDate", query = "SELECT a FROM ApproveCompany a WHERE a.approveCompanyDate = :approveCompanyDate"),
    @NamedQuery(name = "ApproveCompany.findByAprprove", query = "SELECT a FROM ApproveCompany a WHERE a.aprprove = :aprprove")})
public class ApproveCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_approve_company")
    private Integer idApproveCompany;
    @Basic(optional = false)
    @Column(name = "approve_company_date")
    @Temporal(TemporalType.DATE)
    private Date approveCompanyDate;
    @Basic(optional = false)
    @Column(name = "aprprove")
    private boolean aprprove;
    @JoinColumn(name = "company_id_company", referencedColumnName = "id_company")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company companyIdCompany;
    @JoinColumn(name = "usei_id_usei", referencedColumnName = "id_usei")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usei useiIdUsei;

    public ApproveCompany() {
    }

    public ApproveCompany(Integer idApproveCompany) {
        this.idApproveCompany = idApproveCompany;
    }

    public ApproveCompany(Integer idApproveCompany, Date approveCompanyDate, boolean aprprove) {
        this.idApproveCompany = idApproveCompany;
        this.approveCompanyDate = approveCompanyDate;
        this.aprprove = aprprove;
    }

    public Integer getIdApproveCompany() {
        return idApproveCompany;
    }

    public void setIdApproveCompany(Integer idApproveCompany) {
        this.idApproveCompany = idApproveCompany;
    }

    public Date getApproveCompanyDate() {
        return approveCompanyDate;
    }

    public void setApproveCompanyDate(Date approveCompanyDate) {
        this.approveCompanyDate = approveCompanyDate;
    }

    public boolean getAprprove() {
        return aprprove;
    }

    public void setAprprove(boolean aprprove) {
        this.aprprove = aprprove;
    }

    public Company getCompanyIdCompany() {
        return companyIdCompany;
    }

    public void setCompanyIdCompany(Company companyIdCompany) {
        this.companyIdCompany = companyIdCompany;
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
        hash += (idApproveCompany != null ? idApproveCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApproveCompany)) {
            return false;
        }
        ApproveCompany other = (ApproveCompany) object;
        if ((this.idApproveCompany == null && other.idApproveCompany != null) || (this.idApproveCompany != null && !this.idApproveCompany.equals(other.idApproveCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.ApproveCompany[ idApproveCompany=" + idApproveCompany + " ]";
    }
    
}
