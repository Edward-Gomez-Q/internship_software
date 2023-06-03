package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.RoleRepository;
import edu.bo.ucb.sis213.internship.dto.RoleDto;
import edu.bo.ucb.sis213.internship.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleBl {

    @Autowired
    private RoleRepository roleRepository;
    
    //obtener todos los roles
    public List<RoleDto> findAllRoles(){
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    //Convertir un role a roleDto
    private RoleDto convertToDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId_role(role.getId());
        roleDto.setName(role.getRoleName());
        return roleDto;
    }
    //Obtener un role por id
    public RoleDto findById(int id){
        return convertToDto(roleRepository.findById(id));
    }
}
