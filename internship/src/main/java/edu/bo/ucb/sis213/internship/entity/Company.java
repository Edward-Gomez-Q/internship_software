/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByIdCompany", query = "SELECT c FROM Company c WHERE c.idCompany = :idCompany"),
    @NamedQuery(name = "Company.findByNameCompany", query = "SELECT c FROM Company c WHERE c.nameCompany = :nameCompany"),
    @NamedQuery(name = "Company.findByReview", query = "SELECT c FROM Company c WHERE c.review = :review"),
    @NamedQuery(name = "Company.findByUrlIcon", query = "SELECT c FROM Company c WHERE c.urlIcon = :urlIcon"),
    @NamedQuery(name = "Company.findByWebsite", query = "SELECT c FROM Company c WHERE c.website = :website"),
    @NamedQuery(name = "Company.findByNit", query = "SELECT c FROM Company c WHERE c.nit = :nit"),
    @NamedQuery(name = "Company.findByStatus", query = "SELECT c FROM Company c WHERE c.status = :status"),
    @NamedQuery(name = "Company.findByVersionNumber", query = "SELECT c FROM Company c WHERE c.versionNumber = :versionNumber"),
    @NamedQuery(name = "Company.findByAudDate", query = "SELECT c FROM Company c WHERE c.audDate = :audDate"),
    @NamedQuery(name = "Company.findByAudUser", query = "SELECT c FROM Company c WHERE c.audUser = :audUser"),
    @NamedQuery(name = "Company.findByAudHost", query = "SELECT c FROM Company c WHERE c.audHost = :audHost")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_company")
    private Integer idCompany;
    @Basic(optional = false)
    @Column(name = "name_company")
    private String nameCompany;
    @Basic(optional = false)
    @Column(name = "review")
    private String review;
    @Basic(optional = false)
    @Column(name = "url_icon")
    private String urlIcon;
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @Column(name = "version_number")
    @Version
    private int versionNumber;
    @Basic(optional = false)
    @Column(name = "aud_date")
    @Temporal(TemporalType.DATE)
    private Date audDate;
    @Basic(optional = false)
    @Column(name = "aud_user")
    private String audUser;
    @Basic(optional = false)
    @Column(name = "aud_host")
    private String audHost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyIdCompany", fetch = FetchType.LAZY)
    private List<SectorCompany> sectorCompanyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyIdCompany", fetch = FetchType.LAZY)
    private List<Contact> contactList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyIdCompany", fetch = FetchType.LAZY)
    private List<ApproveCompany> approveCompanyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyIdCompany", fetch = FetchType.LAZY)
    private List<Internship> internshipList;

    public Company() {
    }

    public Company(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public Company(Integer idCompany, String nameCompany, String review, String urlIcon, String website, String nit, boolean status, int versionNumber, Date audDate, String audUser, String audHost) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.review = review;
        this.urlIcon = urlIcon;
        this.website = website;
        this.nit = nit;
        this.status = status;
        this.versionNumber = versionNumber;
        this.audDate = audDate;
        this.audUser = audUser;
        this.audHost = audHost;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getAudDate() {
        return audDate;
    }

    public void setAudDate(Date audDate) {
        this.audDate = audDate;
    }

    public String getAudUser() {
        return audUser;
    }

    public void setAudUser(String audUser) {
        this.audUser = audUser;
    }

    public String getAudHost() {
        return audHost;
    }

    public void setAudHost(String audHost) {
        this.audHost = audHost;
    }

    public List<SectorCompany> getSectorCompanyList() {
        return sectorCompanyList;
    }

    public void setSectorCompanyList(List<SectorCompany> sectorCompanyList) {
        this.sectorCompanyList = sectorCompanyList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<ApproveCompany> getApproveCompanyList() {
        return approveCompanyList;
    }

    public void setApproveCompanyList(List<ApproveCompany> approveCompanyList) {
        this.approveCompanyList = approveCompanyList;
    }

    public List<Internship> getInternshipList() {
        return internshipList;
    }

    public void setInternshipList(List<Internship> internshipList) {
        this.internshipList = internshipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompany != null ? idCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.idCompany == null && other.idCompany != null) || (this.idCompany != null && !this.idCompany.equals(other.idCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Company[ idCompany=" + idCompany + " ]";
    }
    
}
