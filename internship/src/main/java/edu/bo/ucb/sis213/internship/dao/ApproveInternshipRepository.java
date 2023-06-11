package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.ApproveInternship;

import java.util.List;

public interface ApproveInternshipRepository extends JpaRepository<ApproveInternship,Integer>{
    List<ApproveInternship> findAllByAprprove(boolean aprprove);
    ApproveInternship findByInternshipIdInternship (Internship internship);
}
