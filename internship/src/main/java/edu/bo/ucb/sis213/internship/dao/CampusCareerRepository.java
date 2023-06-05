package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.Campus;
import edu.bo.ucb.sis213.internship.entity.CampusCareer;
import edu.bo.ucb.sis213.internship.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CampusCareerRepository extends JpaRepository<CampusCareer,Integer> {

}
