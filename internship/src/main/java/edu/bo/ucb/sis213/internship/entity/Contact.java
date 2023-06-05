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
@Table(name = "contact")
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByIdContact", query = "SELECT c FROM Contact c WHERE c.idContact = :idContact"),
    @NamedQuery(name = "Contact.findByMail", query = "SELECT c FROM Contact c WHERE c.mail = :mail"),
    @NamedQuery(name = "Contact.findByPhone", query = "SELECT c FROM Contact c WHERE c.phone = :phone"),
    @NamedQuery(name = "Contact.findByStatus", query = "SELECT c FROM Contact c WHERE c.status = :status"),
    @NamedQuery(name = "Contact.findByVersionNumber", query = "SELECT c FROM Contact c WHERE c.versionNumber = :versionNumber"),
    @NamedQuery(name = "Contact.findByAudDate", query = "SELECT c FROM Contact c WHERE c.audDate = :audDate"),
    @NamedQuery(name = "Contact.findByAudHost", query = "SELECT c FROM Contact c WHERE c.audHost = :audHost"),
    @NamedQuery(name = "Contact.findByAudUser", query = "SELECT c FROM Contact c WHERE c.audUser = :audUser")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contact")
    private Integer idContact;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
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
    @Column(name = "aud_host")
    private String audHost;
    @Basic(optional = false)
    @Column(name = "aud_user")
    private String audUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactIdContact", fetch = FetchType.LAZY)
    private List<NotificationContact> notificationContactList;
    @JoinColumn(name = "company_id_company", referencedColumnName = "id_company")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company companyIdCompany;
    @JoinColumn(name = "person_id_person", referencedColumnName = "id_person")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person personIdPerson;

    public Contact() {
    }

    public Contact(Integer idContact) {
        this.idContact = idContact;
    }

    public Contact(Integer idContact, String mail, String phone, boolean status, int versionNumber, Date audDate, String audHost, String audUser) {
        this.idContact = idContact;
        this.mail = mail;
        this.phone = phone;
        this.status = status;
        this.versionNumber = versionNumber;
        this.audDate = audDate;
        this.audHost = audHost;
        this.audUser = audUser;
    }

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getAudHost() {
        return audHost;
    }

    public void setAudHost(String audHost) {
        this.audHost = audHost;
    }

    public String getAudUser() {
        return audUser;
    }

    public void setAudUser(String audUser) {
        this.audUser = audUser;
    }

    public List<NotificationContact> getNotificationContactList() {
        return notificationContactList;
    }

    public void setNotificationContactList(List<NotificationContact> notificationContactList) {
        this.notificationContactList = notificationContactList;
    }

    public Company getCompanyIdCompany() {
        return companyIdCompany;
    }

    public void setCompanyIdCompany(Company companyIdCompany) {
        this.companyIdCompany = companyIdCompany;
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
        hash += (idContact != null ? idContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.idContact == null && other.idContact != null) || (this.idContact != null && !this.idContact.equals(other.idContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Contact[ idContact=" + idContact + " ]";
    }
    
}
