package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "internship")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_internship")
    private Long internshipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id_company", nullable = false)
    private Company company;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "deadline", nullable = false)
    private Date deadline;

    @Column(name = "days", nullable = false)
    private String days;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "ulr_description", nullable = false)
    private String descriptionUrl;

    @Column(name = "url_syllable", nullable = false)
    private String syllableUrl;

    @Column(name = "knowledge", nullable = false, length = 1000)
    private String knowledge;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "aud_date", nullable = false)
    private Date createDate;

    @Column(name = "aud_host", nullable = false)
    private String txHost;

    @Column(name = "and_user", nullable = false)
    private String txUser;

    public Internship() {
    }

    public Internship(Long internshipId, Company company, String title, String city, Date deadline, String days,
                      Integer duration, Date startTime, Date endTime, String description, String descriptionUrl,
                      String syllableUrl, String knowledge, Boolean status, Integer version, Date createDate,
                      String txHost, String txUser) {
        this.internshipId = internshipId;
        this.company = company;
        this.title = title;
        this.city = city;
        this.deadline = deadline;
        this.days = days;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.descriptionUrl = descriptionUrl;
        this.syllableUrl = syllableUrl;
        this.knowledge = knowledge;
        this.status = status;
        this.version = version;
        this.createDate = createDate;
        this.txHost = txHost;
        this.txUser = txUser;
    }

    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionUrl() {
        return descriptionUrl;
    }

    public void setDescriptionUrl(String descriptionUrl) {
        this.descriptionUrl = descriptionUrl;
    }

    public String getSyllableUrl() {
        return syllableUrl;
    }

    public void setSyllableUrl(String syllableUrl) {
        this.syllableUrl = syllableUrl;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
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

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    @Override
    public String toString() {
        return "Internship{" +
                "internshipId=" + internshipId +
                ", company=" + company +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", deadline=" + deadline +
                ", days='" + days + '\'' +
                ", duration=" + duration +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                ", descriptionUrl='" + descriptionUrl + '\'' +
                ", syllableUrl='" + syllableUrl + '\'' +
                ", knowledge='" + knowledge + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", createDate=" + createDate +
                ", txHost='" + txHost + '\'' +
                ", txUser='" + txUser + '\'' +
                '}';
    }
}
