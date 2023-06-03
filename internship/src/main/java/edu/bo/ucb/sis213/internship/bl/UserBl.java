package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dto.PersonDto;
import edu.bo.ucb.sis213.internship.dto.RoleDto;
import edu.bo.ucb.sis213.internship.dto.UserDto;
import edu.bo.ucb.sis213.internship.entity.Role;
import edu.bo.ucb.sis213.internship.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.bo.ucb.sis213.internship.dao.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserBl {

    @Autowired
    private UserRepository userRepository;
    //Obtener usuario por email
    public UserDto findByEmail(String email){
        return new UserDto(userRepository.findByEmail(email));
    }
    //Obtener roles de un usuario por su id
    public List<RoleDto> findUserRolesById(int userId){
        List<Role> roles = userRepository.findUserRolesById(userId);
        return roles.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    //Convertir un role a roleDto
    private RoleDto convertToDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId_role(role.getId());
        roleDto.setName(role.getRoleName());
        return roleDto;
    }
}
