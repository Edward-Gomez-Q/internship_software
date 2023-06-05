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
@Table(name = "campus")
@NamedQueries({
    @NamedQuery(name = "Campus.findAll", query = "SELECT c FROM Campus c"),
    @NamedQuery(name = "Campus.findByIdCampus", query = "SELECT c FROM Campus c WHERE c.idCampus = :idCampus"),
    @NamedQuery(name = "Campus.findByCampusName", query = "SELECT c FROM Campus c WHERE c.campusName = :campusName")})
public class Campus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_campus")
    private Integer idCampus;
    @Basic(optional = false)
    @Column(name = "campus_name")
    private String campusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campusIdCampus", fetch = FetchType.LAZY)
    private List<CampusCareer> campusCareerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campusIdCampus", fetch = FetchType.LAZY)
    private List<Usei> useiList;

    public Campus() {
    }

    public Campus(Integer idCampus) {
        this.idCampus = idCampus;
    }

    public Campus(Integer idCampus, String campusName) {
        this.idCampus = idCampus;
        this.campusName = campusName;
    }

    public Integer getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(Integer idCampus) {
        this.idCampus = idCampus;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public List<Usei> getUseiList() {
        return useiList;
    }

    public void setUseiList(List<Usei> useiList) {
        this.useiList = useiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampus != null ? idCampus.hashCode() : 0);
        return hash;
    }

    public List<CampusCareer> getCampusCareerList() {
        return campusCareerList;
    }

    public void setCampusCareerList(List<CampusCareer> campusCareerList) {
        this.campusCareerList = campusCareerList;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Campus)) {
            return false;
        }
        Campus other = (Campus) object;
        if ((this.idCampus == null && other.idCampus != null) || (this.idCampus != null && !this.idCampus.equals(other.idCampus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Campus[ idCampus=" + idCampus + " ]";
    }
    
}
