/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "interview")
@NamedQueries({
    @NamedQuery(name = "Interview.findAll", query = "SELECT i FROM Interview i"),
    @NamedQuery(name = "Interview.findByIdInterview", query = "SELECT i FROM Interview i WHERE i.idInterview = :idInterview"),
    @NamedQuery(name = "Interview.findByType", query = "SELECT i FROM Interview i WHERE i.type = :type"),
    @NamedQuery(name = "Interview.findByInterviewDate", query = "SELECT i FROM Interview i WHERE i.interviewDate = :interviewDate"),
    @NamedQuery(name = "Interview.findByStartTime", query = "SELECT i FROM Interview i WHERE i.startTime = :startTime"),
    @NamedQuery(name = "Interview.findByEndTime", query = "SELECT i FROM Interview i WHERE i.endTime = :endTime"),
    @NamedQuery(name = "Interview.findByLocation", query = "SELECT i FROM Interview i WHERE i.location = :location"),
    @NamedQuery(name = "Interview.findByLatitude", query = "SELECT i FROM Interview i WHERE i.latitude = :latitude"),
    @NamedQuery(name = "Interview.findByLongitude", query = "SELECT i FROM Interview i WHERE i.longitude = :longitude"),
    @NamedQuery(name = "Interview.findByNote", query = "SELECT i FROM Interview i WHERE i.note = :note")})
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_interview")
    private Integer idInterview;
    @Basic(optional = false)
    @Column(name = "type")
    private boolean type;
    @Basic(optional = false)
    @Column(name = "interview_date")
    @Temporal(TemporalType.DATE)
    private Date interviewDate;
    @Basic(optional = false)
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "postulation_id_postulation", referencedColumnName = "id_postulation")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Postulation postulationIdPostulation;

    public Interview() {
    }

    public Interview(Integer idInterview) {
        this.idInterview = idInterview;
    }

    public Interview(Integer idInterview, boolean type, Date interviewDate, Date startTime, Date endTime, String location, BigDecimal latitude, BigDecimal longitude, String note) {
        this.idInterview = idInterview;
        this.type = type;
        this.interviewDate = interviewDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.note = note;
    }

    public Integer getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(Integer idInterview) {
        this.idInterview = idInterview;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Postulation getPostulationIdPostulation() {
        return postulationIdPostulation;
    }

    public void setPostulationIdPostulation(Postulation postulationIdPostulation) {
        this.postulationIdPostulation = postulationIdPostulation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInterview != null ? idInterview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interview)) {
            return false;
        }
        Interview other = (Interview) object;
        if ((this.idInterview == null && other.idInterview != null) || (this.idInterview != null && !this.idInterview.equals(other.idInterview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Interview[ idInterview=" + idInterview + " ]";
    }
    
}
