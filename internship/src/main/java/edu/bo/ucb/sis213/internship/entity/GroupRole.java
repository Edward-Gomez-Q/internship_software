package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "group_user")
public class GroupRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_role")
    private int idUserRole;

    @ManyToOne
    @JoinColumn(name = "ro_group_id_group", referencedColumnName = "ro_group")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "ro_role_id_role", referencedColumnName = "ro_role")
    private Role role;
    public GroupRole() {
    }
    public GroupRole(int idUserRole, Group group, Role role) {
        this.idUserRole = idUserRole;
        this.group = group;
        this.role = role;
    }

    @Override
    public String toString() {
        return "GroupRole{" +
                "idUserRole=" + idUserRole +
                ", group=" + group +
                ", role=" + role +
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
