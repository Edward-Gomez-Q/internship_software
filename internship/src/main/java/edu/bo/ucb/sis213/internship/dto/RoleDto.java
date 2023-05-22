package edu.bo.ucb.sis213.internship.dto;

public class RoleDto {
    private int id_role;
    private String name;

    public RoleDto() {
    }
    //Constructor
    public RoleDto(int id_role, String name) {
        this.id_role = id_role;
        this.name = name;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id_role=" + id_role +
                ", name='" + name + '\'' +
                '}';
    }
}
