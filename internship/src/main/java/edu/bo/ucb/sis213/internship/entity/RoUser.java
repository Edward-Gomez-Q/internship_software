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
@Table(name = "ro_user")
@NamedQueries({
    @NamedQuery(name = "RoUser.findAll", query = "SELECT r FROM RoUser r"),
    @NamedQuery(name = "RoUser.findByUserId", query = "SELECT r FROM RoUser r WHERE r.userId = :userId"),
    @NamedQuery(name = "RoUser.findByMail", query = "SELECT r FROM RoUser r WHERE r.mail = :mail"),
    @NamedQuery(name = "RoUser.findByPassword", query = "SELECT r FROM RoUser r WHERE r.password = :password")})
public class RoUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "person_id_person", referencedColumnName = "id_person")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person personIdPerson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roUserUserId", fetch = FetchType.LAZY)
    private List<GroupUser> groupUserList;

    public RoUser() {
    }

    public RoUser(Integer userId) {
        this.userId = userId;
    }

    public RoUser(Integer userId, String mail, String password) {
        this.userId = userId;
        this.mail = mail;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPersonIdPerson() {
        return personIdPerson;
    }

    public void setPersonIdPerson(Person personIdPerson) {
        this.personIdPerson = personIdPerson;
    }

    public List<GroupUser> getGroupUserList() {
        return groupUserList;
    }

    public void setGroupUserList(List<GroupUser> groupUserList) {
        this.groupUserList = groupUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoUser)) {
            return false;
        }
        RoUser other = (RoUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.RoUser[ userId=" + userId + " ]";
    }
    
}
