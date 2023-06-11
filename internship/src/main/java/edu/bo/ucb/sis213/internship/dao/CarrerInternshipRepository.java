package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.CarrerInternship;

import java.util.List;

public interface CarrerInternshipRepository extends JpaRepository<CarrerInternship,Integer>{
    List<CarrerInternship> findAllByInternshipIdInternship(Internship internship);
}
