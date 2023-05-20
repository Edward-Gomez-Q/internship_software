package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "document_id_document", referencedColumnName = "id_document")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "career_id_carrer", referencedColumnName = "id_carrer")
    private Career career;

    @Column(name = "graduate", nullable = false)
    private Boolean graduate;

    @Column(name = "year_of_income", nullable = false)
    private String yearOfIncome;

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

    @ManyToOne
    @JoinColumn(name = "person_id_person", referencedColumnName = "id_person")
    private Person person;

    public Student() {
    }

    public Student(Long studentId, Document document, Career career, Boolean graduate, String yearOfIncome,
                   Boolean status, Integer version, Date audDate, String audHost, String audUser, Person person) {
        this.studentId = studentId;
        this.document = document;
        this.career = career;
        this.graduate = graduate;
        this.yearOfIncome = yearOfIncome;
        this.status = status;
        this.version = version;
        this.audDate = audDate;
        this.audHost = audHost;
        this.audUser = audUser;
        this.person = person;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Boolean getGraduate() {
        return graduate;
    }

    public void setGraduate(Boolean graduate) {
        this.graduate = graduate;
    }

    public String getYearOfIncome() {
        return yearOfIncome;
    }

    public void setYearOfIncome(String yearOfIncome) {
        this.yearOfIncome = yearOfIncome;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", document=" + document +
                ", career=" + career +
                ", graduate=" + graduate +
                ", yearOfIncome='" + yearOfIncome + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", audDate=" + audDate +
                ", audHost='" + audHost + '\'' +
                ", audUser='" + audUser + '\'' +
                ", person=" + person +
                '}';
    }
}