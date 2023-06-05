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
@Table(name = "sector_company")
@NamedQueries({
    @NamedQuery(name = "SectorCompany.findAll", query = "SELECT s FROM SectorCompany s"),
    @NamedQuery(name = "SectorCompany.findByIdSectorCompany", query = "SELECT s FROM SectorCompany s WHERE s.idSectorCompany = :idSectorCompany")})
public class SectorCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sector_company")
    private Integer idSectorCompany;
    @JoinColumn(name = "company_id_company", referencedColumnName = "id_company")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company companyIdCompany;
    @JoinColumn(name = "sector_id_sector", referencedColumnName = "id_sector")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sector sectorIdSector;

    public SectorCompany() {
    }

    public SectorCompany(Integer idSectorCompany) {
        this.idSectorCompany = idSectorCompany;
    }

    public Integer getIdSectorCompany() {
        return idSectorCompany;
    }

    public void setIdSectorCompany(Integer idSectorCompany) {
        this.idSectorCompany = idSectorCompany;
    }

    public Company getCompanyIdCompany() {
        return companyIdCompany;
    }

    public void setCompanyIdCompany(Company companyIdCompany) {
        this.companyIdCompany = companyIdCompany;
    }

    public Sector getSectorIdSector() {
        return sectorIdSector;
    }

    public void setSectorIdSector(Sector sectorIdSector) {
        this.sectorIdSector = sectorIdSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSectorCompany != null ? idSectorCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorCompany)) {
            return false;
        }
        SectorCompany other = (SectorCompany) object;
        if ((this.idSectorCompany == null && other.idSectorCompany != null) || (this.idSectorCompany != null && !this.idSectorCompany.equals(other.idSectorCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.SectorCompany[ idSectorCompany=" + idSectorCompany + " ]";
    }
    
}
