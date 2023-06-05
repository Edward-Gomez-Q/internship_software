package edu.bo.ucb.sis213.internship.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "campus_career")
@NamedQueries({
        @NamedQuery(name = "CampusCareer.findAll", query = "SELECT c FROM CampusCareer c"),
        @NamedQuery(name = "CampusCareer.findByIdCampusCareer", query = "SELECT c FROM CampusCareer c WHERE c.idCampusCareer = :idCampusCareer")})
public class CampusCareer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_campus_career")
    private Integer idCampusCareer;
    @JoinColumn(name = "campus_id_campus", referencedColumnName = "id_campus")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Campus campusIdCampus;
    @JoinColumn(name = "career_id_carrer", referencedColumnName = "id_carrer")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Career careerIdCarrer;

    public CampusCareer() {
    }

    public CampusCareer(Integer idCampusCareer) {
        this.idCampusCareer = idCampusCareer;
    }

    public Integer getIdCampusCareer() {
        return idCampusCareer;
    }

    public void setIdCampusCareer(Integer idCampusCareer) {
        this.idCampusCareer = idCampusCareer;
    }

    public Campus getCampusIdCampus() {
        return campusIdCampus;
    }

    public void setCampusIdCampus(Campus campusIdCampus) {
        this.campusIdCampus = campusIdCampus;
    }

    public Career getCareerIdCarrer() {
        return careerIdCarrer;
    }

    public void setCareerIdCarrer(Career careerIdCarrer) {
        this.careerIdCarrer = careerIdCarrer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampusCareer != null ? idCampusCareer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampusCareer)) {
            return false;
        }
        CampusCareer other = (CampusCareer) object;
        if ((this.idCampusCareer == null && other.idCampusCareer != null) || (this.idCampusCareer != null && !this.idCampusCareer.equals(other.idCampusCareer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.e.CampusCareer[ idCampusCareer=" + idCampusCareer + " ]";
    }

}

