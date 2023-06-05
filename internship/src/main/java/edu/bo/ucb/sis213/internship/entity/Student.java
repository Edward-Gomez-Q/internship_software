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
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdStudent", query = "SELECT s FROM Student s WHERE s.idStudent = :idStudent"),
    @NamedQuery(name = "Student.findByGraduate", query = "SELECT s FROM Student s WHERE s.graduate = :graduate"),
    @NamedQuery(name = "Student.findByYearOfIncome", query = "SELECT s FROM Student s WHERE s.yearOfIncome = :yearOfIncome"),
    @NamedQuery(name = "Student.findByStatus", query = "SELECT s FROM Student s WHERE s.status = :status"),
    @NamedQuery(name = "Student.findByVersionNumber", query = "SELECT s FROM Student s WHERE s.versionNumber = :versionNumber"),
    @NamedQuery(name = "Student.findByAudDate", query = "SELECT s FROM Student s WHERE s.audDate = :audDate"),
    @NamedQuery(name = "Student.findByAudHost", query = "SELECT s FROM Student s WHERE s.audHost = :audHost"),
    @NamedQuery(name = "Student.findByAudUser", query = "SELECT s FROM Student s WHERE s.audUser = :audUser")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_student")
    private Integer idStudent;
    @Basic(optional = false)
    @Column(name = "graduate")
    private boolean graduate;
    @Basic(optional = false)
    @Column(name = "year_of_income")
    private String yearOfIncome;
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
    @JoinColumn(name = "career_id_carrer", referencedColumnName = "id_carrer")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Career careerIdCarrer;
    @JoinColumn(name = "person_id_person", referencedColumnName = "id_person")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person personIdPerson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentIdStudent", fetch = FetchType.LAZY)
    private List<Postulation> postulationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentIdStudent", fetch = FetchType.LAZY)
    private List<NotificationStudent> notificationStudentList;

    public Student() {
    }

    public Student(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Student(Integer idStudent, boolean graduate, String yearOfIncome, boolean status, int versionNumber, Date audDate, String audHost, String audUser) {
        this.idStudent = idStudent;
        this.graduate = graduate;
        this.yearOfIncome = yearOfIncome;
        this.status = status;
        this.versionNumber = versionNumber;
        this.audDate = audDate;
        this.audHost = audHost;
        this.audUser = audUser;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public boolean getGraduate() {
        return graduate;
    }

    public void setGraduate(boolean graduate) {
        this.graduate = graduate;
    }

    public String getYearOfIncome() {
        return yearOfIncome;
    }

    public void setYearOfIncome(String yearOfIncome) {
        this.yearOfIncome = yearOfIncome;
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

    public Career getCareerIdCarrer() {
        return careerIdCarrer;
    }

    public void setCareerIdCarrer(Career careerIdCarrer) {
        this.careerIdCarrer = careerIdCarrer;
    }

    public Person getPersonIdPerson() {
        return personIdPerson;
    }

    public void setPersonIdPerson(Person personIdPerson) {
        this.personIdPerson = personIdPerson;
    }

    public List<Postulation> getPostulationList() {
        return postulationList;
    }

    public void setPostulationList(List<Postulation> postulationList) {
        this.postulationList = postulationList;
    }

    public List<NotificationStudent> getNotificationStudentList() {
        return notificationStudentList;
    }

    public void setNotificationStudentList(List<NotificationStudent> notificationStudentList) {
        this.notificationStudentList = notificationStudentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Student[ idStudent=" + idStudent + " ]";
    }
    
}
