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
@Table(name = "postulation")
@NamedQueries({
    @NamedQuery(name = "Postulation.findAll", query = "SELECT p FROM Postulation p"),
    @NamedQuery(name = "Postulation.findByIdPostulation", query = "SELECT p FROM Postulation p WHERE p.idPostulation = :idPostulation"),
    @NamedQuery(name = "Postulation.findByPresentationDate", query = "SELECT p FROM Postulation p WHERE p.presentationDate = :presentationDate"),
    @NamedQuery(name = "Postulation.findByUrlCv", query = "SELECT p FROM Postulation p WHERE p.urlCv = :urlCv"),
    @NamedQuery(name = "Postulation.findByStatePostulation", query = "SELECT p FROM Postulation p WHERE p.statePostulation = :statePostulation"),
    @NamedQuery(name = "Postulation.findByNote", query = "SELECT p FROM Postulation p WHERE p.note = :note")})
public class Postulation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_postulation")
    private Integer idPostulation;
    @Basic(optional = false)
    @Column(name = "presentation_date")
    @Temporal(TemporalType.DATE)
    private Date presentationDate;
    @Basic(optional = false)
    @Column(name = "url_cv")
    private String urlCv;
    @Basic(optional = false)
    @Column(name = "state_postulation")
    private int statePostulation;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "internship_id_internship", referencedColumnName = "id_internship")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Internship internshipIdInternship;
    @JoinColumn(name = "student_id_student", referencedColumnName = "id_student")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Student studentIdStudent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postulationIdPostulation", fetch = FetchType.LAZY)
    private List<Interview> interviewList;

    public Postulation() {
    }

    public Postulation(Integer idPostulation) {
        this.idPostulation = idPostulation;
    }

    public Postulation(Integer idPostulation, Date presentationDate, String urlCv, int statePostulation, String note) {
        this.idPostulation = idPostulation;
        this.presentationDate = presentationDate;
        this.urlCv = urlCv;
        this.statePostulation = statePostulation;
        this.note = note;
    }

    public Integer getIdPostulation() {
        return idPostulation;
    }

    public void setIdPostulation(Integer idPostulation) {
        this.idPostulation = idPostulation;
    }

    public Date getPresentationDate() {
        return presentationDate;
    }

    public void setPresentationDate(Date presentationDate) {
        this.presentationDate = presentationDate;
    }

    public String getUrlCv() {
        return urlCv;
    }

    public void setUrlCv(String urlCv) {
        this.urlCv = urlCv;
    }

    public int getStatePostulation() {
        return statePostulation;
    }

    public void setStatePostulation(int statePostulation) {
        this.statePostulation = statePostulation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Internship getInternshipIdInternship() {
        return internshipIdInternship;
    }

    public void setInternshipIdInternship(Internship internshipIdInternship) {
        this.internshipIdInternship = internshipIdInternship;
    }

    public Student getStudentIdStudent() {
        return studentIdStudent;
    }

    public void setStudentIdStudent(Student studentIdStudent) {
        this.studentIdStudent = studentIdStudent;
    }

    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void setInterviewList(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostulation != null ? idPostulation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulation)) {
            return false;
        }
        Postulation other = (Postulation) object;
        if ((this.idPostulation == null && other.idPostulation != null) || (this.idPostulation != null && !this.idPostulation.equals(other.idPostulation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Postulation[ idPostulation=" + idPostulation + " ]";
    }
    
}
