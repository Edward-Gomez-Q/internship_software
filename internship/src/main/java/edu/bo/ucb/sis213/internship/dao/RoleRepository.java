package edu.bo.ucb.sis213.internship.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.Role;
public interface RoleRepository extends JpaRepository<Role,Integer>{
    //Obtener un Role por el id
    Role findById(int id);
}