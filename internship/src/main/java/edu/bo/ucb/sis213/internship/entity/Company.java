package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;
import  java.util.Date;

@Entity
@Table(name="company")
public class Company{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private int companyId;

    @Column(name = "name_company", nullable = false)
    private String businessName;

    @Column(name = "review", nullable = false, length = 1000)
    private String tradeName;

    @Column(name = "url_icon", nullable = false)
    private String logoUrl;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "NIT", nullable = false)
    private String taxId;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Version
    @Column(name = "version_number", nullable = false)
    private Integer version;

    @Column(name = "aud_date", nullable = false)
    private Date createDate;

    @Column(name = "aud_user", nullable = false)
    private String txUser;

    @Column(name = "aud_host", nullable = false)
    private String txHost;

    public Company() {
    }

    public Company(int companyId, String businessName, String tradeName, String logoUrl, String website,
                   String taxId, Boolean status, Integer version, Date createDate, String txUser,
                   String txHost) {
        this.companyId = companyId;
        this.businessName = businessName;
        this.tradeName = tradeName;
        this.logoUrl = logoUrl;
        this.website = website;
        this.taxId = taxId;
        this.status = status;
        this.version = version;
        this.createDate = createDate;
        this.txUser = txUser;
        this.txHost = txHost;
    }
    // Getters and Setters

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }
    // toString

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", businessName='" + businessName + '\'' +
                ", tradeName='" + tradeName + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", website='" + website + '\'' +
                ", taxId='" + taxId + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", createDate=" + createDate +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
