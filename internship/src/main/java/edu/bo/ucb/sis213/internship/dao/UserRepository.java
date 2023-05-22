package edu.bo.ucb.sis213.internship.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.User;
public interface UserRepository extends JpaRepository<User,Integer>{
}
