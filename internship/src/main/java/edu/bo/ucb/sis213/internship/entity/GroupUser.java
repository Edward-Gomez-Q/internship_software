/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "group_user")
@NamedQueries({
    @NamedQuery(name = "GroupUser.findAll", query = "SELECT g FROM GroupUser g"),
    @NamedQuery(name = "GroupUser.findByIdGroupUser", query = "SELECT g FROM GroupUser g WHERE g.idGroupUser = :idGroupUser")})
public class GroupUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_group_user")
    private Integer idGroupUser;
    @JoinColumn(name = "ro_group_id_group", referencedColumnName = "id_group")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RoGroup roGroupIdGroup;
    @JoinColumn(name = "ro_user_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RoUser roUserUserId;

    public GroupUser() {
    }

    public GroupUser(Integer idGroupUser) {
        this.idGroupUser = idGroupUser;
    }

    public Integer getIdGroupUser() {
        return idGroupUser;
    }

    public void setIdGroupUser(Integer idGroupUser) {
        this.idGroupUser = idGroupUser;
    }

    public RoGroup getRoGroupIdGroup() {
        return roGroupIdGroup;
    }

    public void setRoGroupIdGroup(RoGroup roGroupIdGroup) {
        this.roGroupIdGroup = roGroupIdGroup;
    }

    public RoUser getRoUserUserId() {
        return roUserUserId;
    }

    public void setRoUserUserId(RoUser roUserUserId) {
        this.roUserUserId = roUserUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupUser != null ? idGroupUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupUser)) {
            return false;
        }
        GroupUser other = (GroupUser) object;
        if ((this.idGroupUser == null && other.idGroupUser != null) || (this.idGroupUser != null && !this.idGroupUser.equals(other.idGroupUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.GroupUser[ idGroupUser=" + idGroupUser + " ]";
    }
    
}
