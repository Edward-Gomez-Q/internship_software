package edu.bo.ucb.sis213.internship.dao;
import edu.bo.ucb.sis213.internship.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long>{
}
