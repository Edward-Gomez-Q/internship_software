package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "sector_company")
public class SectorCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sector_company")
    private Long sectorCompanyId;

    @ManyToOne
    @JoinColumn(name = "sector_id_sector", referencedColumnName = "id_sector")
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "company_id_company", referencedColumnName = "id_company")
    private Company company;

    public SectorCompany() {
    }

    public SectorCompany(Long sectorCompanyId, Sector sector, Company company) {
        this.sectorCompanyId = sectorCompanyId;
        this.sector = sector;
        this.company = company;
    }

    public Long getSectorCompanyId() {
        return sectorCompanyId;
    }

    public void setSectorCompanyId(Long sectorCompanyId) {
        this.sectorCompanyId = sectorCompanyId;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "SectorCompany{" +
                "sectorCompanyId=" + sectorCompanyId +
                ", sector=" + sector +
                ", company=" + company +
                '}';
    }
}