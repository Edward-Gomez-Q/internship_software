/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author HP
 */
@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson"),
    @NamedQuery(name = "Person.findByNames", query = "SELECT p FROM Person p WHERE p.names = :names"),
    @NamedQuery(name = "Person.findByFirstLastName", query = "SELECT p FROM Person p WHERE p.firstLastName = :firstLastName"),
    @NamedQuery(name = "Person.findBySecondLastName", query = "SELECT p FROM Person p WHERE p.secondLastName = :secondLastName"),
    @NamedQuery(name = "Person.findByDocumentPerson", query = "SELECT p FROM Person p WHERE p.documentPerson = :documentPerson"),
    @NamedQuery(name = "Person.findByDocumentComplemet", query = "SELECT p FROM Person p WHERE p.documentComplemet = :documentComplemet")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_person")
    private Integer idPerson;
    @Basic(optional = false)
    @Column(name = "names")
    private String names;
    @Basic(optional = false)
    @Column(name = "first_last_name")
    private String firstLastName;
    @Basic(optional = false)
    @Column(name = "second_last_name")
    private String secondLastName;
    @Basic(optional = false)
    @Column(name = "document_person")
    private String documentPerson;
    @Basic(optional = false)
    @Column(name = "document_complemet")
    private String documentComplemet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personIdPerson", fetch = FetchType.LAZY)
    private List<Student> studentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personIdPerson", fetch = FetchType.LAZY)
    private List<Contact> contactList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personIdPerson", fetch = FetchType.LAZY)
    private List<RoUser> roUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personIdPerson", fetch = FetchType.LAZY)
    private List<Usei> useiList;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Integer idPerson, String names, String firstLastName, String secondLastName, String documentPerson, String documentComplemet) {
        this.idPerson = idPerson;
        this.names = names;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.documentPerson = documentPerson;
        this.documentComplemet = documentComplemet;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getDocumentPerson() {
        return documentPerson;
    }

    public void setDocumentPerson(String documentPerson) {
        this.documentPerson = documentPerson;
    }

    public String getDocumentComplemet() {
        return documentComplemet;
    }

    public void setDocumentComplemet(String documentComplemet) {
        this.documentComplemet = documentComplemet;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<RoUser> getRoUserList() {
        return roUserList;
    }

    public void setRoUserList(List<RoUser> roUserList) {
        this.roUserList = roUserList;
    }

    public List<Usei> getUseiList() {
        return useiList;
    }

    public void setUseiList(List<Usei> useiList) {
        this.useiList = useiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.Person[ idPerson=" + idPerson + " ]";
    }
    
}
