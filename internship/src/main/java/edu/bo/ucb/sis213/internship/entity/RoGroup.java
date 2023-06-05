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
@Table(name = "ro_group")
@NamedQueries({
    @NamedQuery(name = "RoGroup.findAll", query = "SELECT r FROM RoGroup r"),
    @NamedQuery(name = "RoGroup.findByIdGroup", query = "SELECT r FROM RoGroup r WHERE r.idGroup = :idGroup"),
    @NamedQuery(name = "RoGroup.findByGroupName", query = "SELECT r FROM RoGroup r WHERE r.groupName = :groupName")})
public class RoGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_group")
    private Integer idGroup;
    @Basic(optional = false)
    @Column(name = "group_name")
    private String groupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roGroupIdGroup", fetch = FetchType.LAZY)
    private List<GroupRole> groupRoleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roGroupIdGroup", fetch = FetchType.LAZY)
    private List<GroupUser> groupUserList;

    public RoGroup() {
    }

    public RoGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public RoGroup(Integer idGroup, String groupName) {
        this.idGroup = idGroup;
        this.groupName = groupName;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<GroupRole> getGroupRoleList() {
        return groupRoleList;
    }

    public void setGroupRoleList(List<GroupRole> groupRoleList) {
        this.groupRoleList = groupRoleList;
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
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoGroup)) {
            return false;
        }
        RoGroup other = (RoGroup) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.RoGroup[ idGroup=" + idGroup + " ]";
    }
    
}
