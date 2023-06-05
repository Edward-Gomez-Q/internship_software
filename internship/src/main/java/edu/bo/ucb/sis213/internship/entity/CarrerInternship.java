/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "carrer_internship")
@NamedQueries({
    @NamedQuery(name = "CarrerInternship.findAll", query = "SELECT c FROM CarrerInternship c"),
    @NamedQuery(name = "CarrerInternship.findByIdCarrerIntership", query = "SELECT c FROM CarrerInternship c WHERE c.idCarrerIntership = :idCarrerIntership")})
public class CarrerInternship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrer_intership")
    private Integer idCarrerIntership;
    @JoinColumn(name = "career_id_carrer", referencedColumnName = "id_carrer")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Career careerIdCarrer;
    @JoinColumn(name = "internship_id_internship", referencedColumnName = "id_internship")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Internship internshipIdInternship;

    public CarrerInternship() {
    }

    public CarrerInternship(Integer idCarrerIntership) {
        this.idCarrerIntership = idCarrerIntership;
    }

    public Integer getIdCarrerIntership() {
        return idCarrerIntership;
    }

    public void setIdCarrerIntership(Integer idCarrerIntership) {
        this.idCarrerIntership = idCarrerIntership;
    }

    public Career getCareerIdCarrer() {
        return careerIdCarrer;
    }

    public void setCareerIdCarrer(Career careerIdCarrer) {
        this.careerIdCarrer = careerIdCarrer;
    }

    public Internship getInternshipIdInternship() {
        return internshipIdInternship;
    }

    public void setInternshipIdInternship(Internship internshipIdInternship) {
        this.internshipIdInternship = internshipIdInternship;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrerIntership != null ? idCarrerIntership.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarrerInternship)) {
            return false;
        }
        CarrerInternship other = (CarrerInternship) object;
        if ((this.idCarrerIntership == null && other.idCarrerIntership != null) || (this.idCarrerIntership != null && !this.idCarrerIntership.equals(other.idCarrerIntership))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.CarrerInternship[ idCarrerIntership=" + idCarrerIntership + " ]";
    }
    
}
