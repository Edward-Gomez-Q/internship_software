/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usei")
@NamedQueries({
    @NamedQuery(name = "Usei.findAll", query = "SELECT u FROM Usei u"),
    @NamedQuery(name = "Usei.findByIdUsei", query = "SELECT u FROM Usei u WHERE u.idUsei = :idUsei")})
public class Usei implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usei")
    private Integer idUsei;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useiIdUsei", fetch = FetchType.LAZY)
    private List<ApproveInternship> approveInternshipList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useiIdUsei", fetch = FetchType.LAZY)
    private List<ApproveCompany> approveCompanyList;
    @JoinColumn(name = "campus_id_campus", referencedColumnName = "id_campus")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Campus campusIdCampus;
    @JoinColumn(name = "person_id_person", referencedColumnName = "id_person")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person personIdPerson;

    public Usei() {
    }

    public Usei(Integer idUsei) {
        this.idUsei = idUsei;
    }

    public Integer getIdUsei() {
        return idUsei;
    }

    public void setIdUsei(Integer idUsei) {
        this.idUsei = idUsei;
    }

    public List<ApproveInternship> getApproveInternshipList() {
        return approveInternshipList;
    }

    public void setApproveInternshipList(List<ApproveInternship> approveInternshipList) {
        this.approveInternshipList = approveInternshipList;
    }

    public List<ApproveCompany> getApproveCompanyList() {
        return approveCompanyList;
    }

    public void setApproveCompanyList(List<ApproveCompany> approveCompanyList) {
        this.approveCompanyList = approveCompanyList;
    }

    public Campus getCampusIdCampus() {
        return campusIdCampus;
    }

    public void setCampusIdCampus(Campus campusIdCampus) {
        this.campusIdCampus = campusIdCampus;
    }

    public Person getPersonIdPerson() {
        return personIdPerson;
    }

    public void setPersonIdPerson(Person personIdPerson) {
        this.personIdPerson = personIdPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsei != null ? idUsei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usei)) {
            return false;
        }
        Usei other = (Usei) object;
        if ((this.idUsei == null && other.idUsei != null) || (this.idUsei != null && !this.idUsei.equals(other.idUsei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Usei[ idUsei=" + idUsei + " ]";
    }
    
}
