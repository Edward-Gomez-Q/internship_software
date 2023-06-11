package edu.bo.ucb.sis213.internship.dao;
import edu.bo.ucb.sis213.internship.entity.GroupUser;
import edu.bo.ucb.sis213.internship.entity.RoUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GroupUserRepository extends JpaRepository<GroupUser,Integer>{
    //buscar por id de usuario
    public GroupUser findByRoUserUserId(RoUser roUser);
}
