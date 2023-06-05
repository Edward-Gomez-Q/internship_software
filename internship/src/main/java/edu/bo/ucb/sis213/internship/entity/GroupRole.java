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
@Table(name = "group_role")
@NamedQueries({
    @NamedQuery(name = "GroupRole.findAll", query = "SELECT g FROM GroupRole g"),
    @NamedQuery(name = "GroupRole.findByIdUserRole", query = "SELECT g FROM GroupRole g WHERE g.idUserRole = :idUserRole")})
public class GroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_role")
    private Integer idUserRole;
    @JoinColumn(name = "ro_group_id_group", referencedColumnName = "id_group")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RoGroup roGroupIdGroup;
    @JoinColumn(name = "ro_role_id_role", referencedColumnName = "id_role")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RoRole roRoleIdRole;

    public GroupRole() {
    }

    public GroupRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Integer getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }

    public RoGroup getRoGroupIdGroup() {
        return roGroupIdGroup;
    }

    public void setRoGroupIdGroup(RoGroup roGroupIdGroup) {
        this.roGroupIdGroup = roGroupIdGroup;
    }

    public RoRole getRoRoleIdRole() {
        return roRoleIdRole;
    }

    public void setRoRoleIdRole(RoRole roRoleIdRole) {
        this.roRoleIdRole = roRoleIdRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserRole != null ? idUserRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupRole)) {
            return false;
        }
        GroupRole other = (GroupRole) object;
        if ((this.idUserRole == null && other.idUserRole != null) || (this.idUserRole != null && !this.idUserRole.equals(other.idUserRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.GroupRole[ idUserRole=" + idUserRole + " ]";
    }
    
}
