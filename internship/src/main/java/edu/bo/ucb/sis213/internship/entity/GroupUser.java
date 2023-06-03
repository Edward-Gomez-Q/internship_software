package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "group_user")
public class GroupUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group_user")
    private int idUserRole;

    @ManyToOne
    @JoinColumn(name = "ro_group_id_group", referencedColumnName = "ro_group")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "ro_user_user_id", referencedColumnName = "ro_user")
    private User user;
    public GroupUser() {
    }

    public GroupUser(int idUserRole, Group group, User user) {
        this.idUserRole = idUserRole;
        this.group = group;
        this.user = user;
    }

    @Override
    public String toString() {
        return "GroupUser{" +
                "idUserRole=" + idUserRole +
                ", group=" + group +
                ", user=" + user +
                '}';
    }

    public int getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
