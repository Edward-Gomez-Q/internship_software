package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_group")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id_group", referencedColumnName = "id_group")
    private Group group;

    public UserGroup() {
    }

    public UserGroup(Long id, User user, Group group) {
        this.id = id;
        this.user = user;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + id +
                ", user=" + user +
                ", group=" + group +
                '}';
    }
}
