package edu.bo.ucb.sis213.internship.dao;
import edu.bo.ucb.sis213.internship.entity.RoRole;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.RoUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<RoUser,Integer>{
    public RoUser findByMail(String mail);
    @Query("SELECT r FROM RoUser u " +
            "JOIN GroupUser gu ON u.userId = gu.roUserUserId.userId " +
            "JOIN GroupRole gr ON gu.roGroupIdGroup.idGroup = gr.roGroupIdGroup.idGroup " +
            "JOIN RoRole r ON gr.roRoleIdRole.idRole = r.idRole " +
            "WHERE u.userId = :userId")
    List<RoRole> findUserRolesById(@Param("userId") int userId);
}
