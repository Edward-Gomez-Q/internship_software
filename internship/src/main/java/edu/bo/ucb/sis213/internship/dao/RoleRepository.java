package edu.bo.ucb.sis213.internship.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.RoRole;
public interface RoleRepository extends JpaRepository<RoRole,Integer>{
    //Obtener un Role por el id
    RoRole findById(int id);
}
