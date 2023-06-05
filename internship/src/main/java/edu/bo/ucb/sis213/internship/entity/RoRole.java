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
@Table(name = "ro_role")
@NamedQueries({
    @NamedQuery(name = "RoRole.findAll", query = "SELECT r FROM RoRole r"),
    @NamedQuery(name = "RoRole.findByIdRole", query = "SELECT r FROM RoRole r WHERE r.idRole = :idRole"),
    @NamedQuery(name = "RoRole.findByRoleName", query = "SELECT r FROM RoRole r WHERE r.roleName = :roleName")})
public class RoRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_role")
    private Integer idRole;
    @Basic(optional = false)
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roRoleIdRole", fetch = FetchType.LAZY)
    private List<GroupRole> groupRoleList;

    public RoRole() {
    }

    public RoRole(Integer idRole) {
        this.idRole = idRole;
    }

    public RoRole(Integer idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<GroupRole> getGroupRoleList() {
        return groupRoleList;
    }

    public void setGroupRoleList(List<GroupRole> groupRoleList) {
        this.groupRoleList = groupRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoRole)) {
            return false;
        }
        RoRole other = (RoRole) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.RoRole[ idRole=" + idRole + " ]";
    }
    
}
