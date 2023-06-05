/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author HP
 */
@Entity
@Table(name = "career")
@NamedQueries({
    @NamedQuery(name = "Career.findAll", query = "SELECT c FROM Career c"),
    @NamedQuery(name = "Career.findByIdCarrer", query = "SELECT c FROM Career c WHERE c.idCarrer = :idCarrer"),
    @NamedQuery(name = "Career.findByCareerName", query = "SELECT c FROM Career c WHERE c.careerName = :careerName")})
public class Career implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrer")
    private Integer idCarrer;
    @Basic(optional = false)
    @Column(name = "career_name")
    private String careerName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "careerIdCarrer", fetch = FetchType.LAZY)
    private List<Student> studentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "careerIdCarrer", fetch = FetchType.LAZY)
    private List<CarrerInternship> carrerInternshipList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "careerIdCarrer", fetch = FetchType.LAZY)
    private List<CampusCareer> campusCareerList;

    public Career() {
    }

    public Career(Integer idCarrer) {
        this.idCarrer = idCarrer;
    }

    public Career(Integer idCarrer, String careerName) {
        this.idCarrer = idCarrer;
        this.careerName = careerName;
    }

    public Integer getIdCarrer() {
        return idCarrer;
    }

    public void setIdCarrer(Integer idCarrer) {
        this.idCarrer = idCarrer;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<CarrerInternship> getCarrerInternshipList() {
        return carrerInternshipList;
    }

    public void setCarrerInternshipList(List<CarrerInternship> carrerInternshipList) {
        this.carrerInternshipList = carrerInternshipList;
    }

    public List<CampusCareer> getCampusCareerList() {
        return campusCareerList;
    }

    public void setCampusCareerList(List<CampusCareer> campusCareerList) {
        this.campusCareerList = campusCareerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrer != null ? idCarrer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Career)) {
            return false;
        }
        Career other = (Career) object;
        if ((this.idCarrer == null && other.idCarrer != null) || (this.idCarrer != null && !this.idCarrer.equals(other.idCarrer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Career[ idCarrer=" + idCarrer + " ]";
    }
    
}
