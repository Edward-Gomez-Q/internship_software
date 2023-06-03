package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interview")
    private Integer idInterview;

    //
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postulation_id_postulation", referencedColumnName = "id_postulation")
    private Postulation postulation;

    @Column(name = "type", nullable = false)
    private Boolean type;

    @Column(name = "interview_date", nullable = false)
    private Date interviewDate;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @Column(name = "note", nullable = false)
    private String note;
    // Constructor vacio
    public Interview() {
    }

    public Interview(Integer idInterview, Postulation postulation, Boolean type, Date interviewDate, Time startTime, Time endTime, String location, BigDecimal latitude, BigDecimal longitude, String note) {
        this.idInterview = idInterview;
        this.postulation = postulation;
        this.type = type;
        this.interviewDate = interviewDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "idInterview=" + idInterview +
                ", postulation=" + postulation +
                ", type=" + type +
                ", interviewDate=" + interviewDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", note='" + note + '\'' +
                '}';
    }

    public Integer getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(Integer idInterview) {
        this.idInterview = idInterview;
    }

    public Postulation getPostulation() {
        return postulation;
    }

    public void setPostulation(Postulation postulation) {
        this.postulation = postulation;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
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
}
