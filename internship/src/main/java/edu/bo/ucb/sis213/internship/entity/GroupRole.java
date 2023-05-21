package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "group_role")
public class GroupRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group_role")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id_group", referencedColumnName = "id_group")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Role_id_role", referencedColumnName = "id_role")
    private Role role;

    public GroupRole() {
    }

    public GroupRole(Long id, Group group, Role role) {
        this.id = id;
        this.group = group;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "GroupRole{" +
                "id=" + id +
                ", group=" + group +
                ", role=" + role +
                '}';
    }
}