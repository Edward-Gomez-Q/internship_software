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
@Table(name = "sector")
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s"),
    @NamedQuery(name = "Sector.findByIdSector", query = "SELECT s FROM Sector s WHERE s.idSector = :idSector"),
    @NamedQuery(name = "Sector.findBySectorName", query = "SELECT s FROM Sector s WHERE s.sectorName = :sectorName")})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sector")
    private Integer idSector;
    @Basic(optional = false)
    @Column(name = "sector_name")
    private String sectorName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectorIdSector", fetch = FetchType.LAZY)
    private List<SectorCompany> sectorCompanyList;

    public Sector() {
    }

    public Sector(Integer idSector) {
        this.idSector = idSector;
    }

    public Sector(Integer idSector, String sectorName) {
        this.idSector = idSector;
        this.sectorName = sectorName;
    }

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public List<SectorCompany> getSectorCompanyList() {
        return sectorCompanyList;
    }

    public void setSectorCompanyList(List<SectorCompany> sectorCompanyList) {
        this.sectorCompanyList = sectorCompanyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSector != null ? idSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idSector == null && other.idSector != null) || (this.idSector != null && !this.idSector.equals(other.idSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Sector[ idSector=" + idSector + " ]";
    }
    
}
