package edu.bo.ucb.sis213.internship.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.UserRole;
public interface UserRoleRepository extends JpaRepository<UserRole,Integer>{
    //Obtener un UserRole por el id de User
    UserRole findByUser(int id);
}
