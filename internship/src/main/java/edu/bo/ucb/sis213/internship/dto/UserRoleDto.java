package edu.bo.ucb.sis213.internship.dto;

public class UserRoleDto {
    int idUserRole;
    UserDto userDto;
    RoleDto roleDto;
    //Builder
    public UserRoleDto() {
    }
    //Builder
    public UserRoleDto(int idUserRole, UserDto userDto, RoleDto roleDto) {
        this.idUserRole = idUserRole;
        this.userDto = userDto;
        this.roleDto = roleDto;
    }
    //Getters and Setters

    public int getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        this.idUserRole = idUserRole;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public RoleDto getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(RoleDto roleDto) {
        this.roleDto = roleDto;
    }
    //ToString

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "idUserRole=" + idUserRole +
                ", userDto=" + userDto +
                ", roleDto=" + roleDto +
                '}';
    }
}
