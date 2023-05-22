package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.UserRoleRepository;
import edu.bo.ucb.sis213.internship.entity.UserRole;
import org.springframework.stereotype.Service;

@Service
public class UserRoleBl {
    private final UserRoleRepository userRoleRepository;
    //Constructor
    public UserRoleBl(UserRoleRepository userRoleRepository){
        this.userRoleRepository = userRoleRepository;
    }
    //aggregate a UserRole
    public UserRole saveUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }
    //get a UserRole by id
    public UserRole findByUser(int id){
        return userRoleRepository.findByUser(id);
    }
}
