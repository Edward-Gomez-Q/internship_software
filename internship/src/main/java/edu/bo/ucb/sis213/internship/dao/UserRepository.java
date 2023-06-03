package edu.bo.ucb.sis213.internship.dao;
import edu.bo.ucb.sis213.internship.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByEmail(String email);

    @Query("SELECT r FROM User u " +
            "JOIN GroupUser gu ON u.id = gu.user.id " +
            "JOIN GroupRole gr ON gu.group.id = gr.group.id " +
            "JOIN Role r ON gr.role.id = r.id " +
            "WHERE u.id = :userId")
    List<Role> findUserRolesById(@Param("userId") int userId);
}
