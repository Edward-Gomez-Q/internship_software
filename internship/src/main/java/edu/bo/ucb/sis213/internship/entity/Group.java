package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "\"group\"")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    public Group() {
    }

    public Group(Long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}