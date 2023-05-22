package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.RoleRepository;
import edu.bo.ucb.sis213.internship.dto.RoleDto;
import edu.bo.ucb.sis213.internship.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleBl {
    private final RoleRepository roleRepository;
    //Constructor
    public RoleBl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    //get all roles
    public List<RoleDto> findAllRoles(){
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    //Convert role to roleDto
    private RoleDto convertToDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId_role(role.getId());
        roleDto.setName(role.getRoleName());
        return roleDto;
    }
    //get a role by id
    public Role findById(int id){
        return roleRepository.findById(id);
    }
}
