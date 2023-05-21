package edu.bo.ucb.sis213.internship.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.NotificationType;
public interface NotificationTypeRepository extends JpaRepository<NotificationType,Long>{
}
