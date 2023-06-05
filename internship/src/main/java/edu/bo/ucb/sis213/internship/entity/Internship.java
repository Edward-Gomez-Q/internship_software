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
@Table(name = "internship")
@NamedQueries({
    @NamedQuery(name = "Internship.findAll", query = "SELECT i FROM Internship i"),
    @NamedQuery(name = "Internship.findByIdInternship", query = "SELECT i FROM Internship i WHERE i.idInternship = :idInternship"),
    @NamedQuery(name = "Internship.findByTitle", query = "SELECT i FROM Internship i WHERE i.title = :title"),
    @NamedQuery(name = "Internship.findByCity", query = "SELECT i FROM Internship i WHERE i.city = :city"),
    @NamedQuery(name = "Internship.findByDeadline", query = "SELECT i FROM Internship i WHERE i.deadline = :deadline"),
    @NamedQuery(name = "Internship.findByDays", query = "SELECT i FROM Internship i WHERE i.days = :days"),
    @NamedQuery(name = "Internship.findByDuration", query = "SELECT i FROM Internship i WHERE i.duration = :duration"),
    @NamedQuery(name = "Internship.findByStartTimeInternship", query = "SELECT i FROM Internship i WHERE i.startTimeInternship = :startTimeInternship"),
    @NamedQuery(name = "Internship.findByEndTimeInternship", query = "SELECT i FROM Internship i WHERE i.endTimeInternship = :endTimeInternship"),
    @NamedQuery(name = "Internship.findByDescription", query = "SELECT i FROM Internship i WHERE i.description = :description"),
    @NamedQuery(name = "Internship.findByUlrDescription", query = "SELECT i FROM Internship i WHERE i.ulrDescription = :ulrDescription"),
    @NamedQuery(name = "Internship.findByUrlSyllable", query = "SELECT i FROM Internship i WHERE i.urlSyllable = :urlSyllable"),
    @NamedQuery(name = "Internship.findByKnowledge", query = "SELECT i FROM Internship i WHERE i.knowledge = :knowledge"),
    @NamedQuery(name = "Internship.findByStatus", query = "SELECT i FROM Internship i WHERE i.status = :status"),
    @NamedQuery(name = "Internship.findByVersionNumber", query = "SELECT i FROM Internship i WHERE i.versionNumber = :versionNumber"),
    @NamedQuery(name = "Internship.findByAudDate", query = "SELECT i FROM Internship i WHERE i.audDate = :audDate"),
    @NamedQuery(name = "Internship.findByAudHost", query = "SELECT i FROM Internship i WHERE i.audHost = :audHost"),
    @NamedQuery(name = "Internship.findByAndUser", query = "SELECT i FROM Internship i WHERE i.andUser = :andUser")})
public class Internship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_internship")
    private Integer idInternship;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    @Basic(optional = false)
    @Column(name = "days")
    private String days;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "start_time_internship")
    @Temporal(TemporalType.TIME)
    private Date startTimeInternship;
    @Basic(optional = false)
    @Column(name = "end_time_internship")
    @Temporal(TemporalType.TIME)
    private Date endTimeInternship;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "ulr_description")
    private String ulrDescription;
    @Basic(optional = false)
    @Column(name = "url_syllable")
    private String urlSyllable;
    @Basic(optional = false)
    @Column(name = "knowledge")
    private String knowledge;
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
    @Column(name = "and_user")
    private String andUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "internshipIdInternship", fetch = FetchType.LAZY)
    private List<CarrerInternship> carrerInternshipList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "internshipIdInternship", fetch = FetchType.LAZY)
    private List<ApproveInternship> approveInternshipList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "internshipIdInternship", fetch = FetchType.LAZY)
    private List<Postulation> postulationList;
    @JoinColumn(name = "company_id_company", referencedColumnName = "id_company")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company companyIdCompany;

    public Internship() {
    }

    public Internship(Integer idInternship) {
        this.idInternship = idInternship;
    }

    public Internship(Integer idInternship, String title, String city, Date deadline, String days, int duration, Date startTimeInternship, Date endTimeInternship, String description, String ulrDescription, String urlSyllable, String knowledge, boolean status, int versionNumber, Date audDate, String audHost, String andUser) {
        this.idInternship = idInternship;
        this.title = title;
        this.city = city;
        this.deadline = deadline;
        this.days = days;
        this.duration = duration;
        this.startTimeInternship = startTimeInternship;
        this.endTimeInternship = endTimeInternship;
        this.description = description;
        this.ulrDescription = ulrDescription;
        this.urlSyllable = urlSyllable;
        this.knowledge = knowledge;
        this.status = status;
        this.versionNumber = versionNumber;
        this.audDate = audDate;
        this.audHost = audHost;
        this.andUser = andUser;
    }

    public Integer getIdInternship() {
        return idInternship;
    }

    public void setIdInternship(Integer idInternship) {
        this.idInternship = idInternship;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartTimeInternship() {
        return startTimeInternship;
    }

    public void setStartTimeInternship(Date startTimeInternship) {
        this.startTimeInternship = startTimeInternship;
    }

    public Date getEndTimeInternship() {
        return endTimeInternship;
    }

    public void setEndTimeInternship(Date endTimeInternship) {
        this.endTimeInternship = endTimeInternship;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUlrDescription() {
        return ulrDescription;
    }

    public void setUlrDescription(String ulrDescription) {
        this.ulrDescription = ulrDescription;
    }

    public String getUrlSyllable() {
        return urlSyllable;
    }

    public void setUrlSyllable(String urlSyllable) {
        this.urlSyllable = urlSyllable;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
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

    public String getAndUser() {
        return andUser;
    }

    public void setAndUser(String andUser) {
        this.andUser = andUser;
    }

    public List<CarrerInternship> getCarrerInternshipList() {
        return carrerInternshipList;
    }

    public void setCarrerInternshipList(List<CarrerInternship> carrerInternshipList) {
        this.carrerInternshipList = carrerInternshipList;
    }

    public List<ApproveInternship> getApproveInternshipList() {
        return approveInternshipList;
    }

    public void setApproveInternshipList(List<ApproveInternship> approveInternshipList) {
        this.approveInternshipList = approveInternshipList;
    }

    public List<Postulation> getPostulationList() {
        return postulationList;
    }

    public void setPostulationList(List<Postulation> postulationList) {
        this.postulationList = postulationList;
    }

    public Company getCompanyIdCompany() {
        return companyIdCompany;
    }

    public void setCompanyIdCompany(Company companyIdCompany) {
        this.companyIdCompany = companyIdCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInternship != null ? idInternship.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Internship)) {
            return false;
        }
        Internship other = (Internship) object;
        if ((this.idInternship == null && other.idInternship != null) || (this.idInternship != null && !this.idInternship.equals(other.idInternship))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Internship[ idInternship=" + idInternship + " ]";
    }
    
}
