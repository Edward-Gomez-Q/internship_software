package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private int contactId;

    @ManyToOne
    @JoinColumn(name = "person_id_person", referencedColumnName = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "company_id_company", referencedColumnName = "id_company")
    private Company company;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "aud_date", nullable = false)
    private Date audDate;

    @Column(name = "aud_host", nullable = false)
    private String audHost;

    @Column(name = "aud_user", nullable = false)
    private String audUser;

    public Contact() {
    }

    public Contact(int contactId, Person person, Company company, String mail, String phone, Boolean status,
                   Integer version, Date audDate, String audHost, String audUser) {
        this.contactId = contactId;
        this.person = person;
        this.company = company;
        this.mail = mail;
        this.phone = phone;
        this.status = status;
        this.version = version;
        this.audDate = audDate;
        this.audHost = audHost;
        this.audUser = audUser;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", person=" + person +
                ", company=" + company +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", audDate=" + audDate +
                ", audHost='" + audHost + '\'' +
                ", audUser='" + audUser + '\'' +
                '}';
    }
}
