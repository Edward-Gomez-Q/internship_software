package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepository extends JpaRepository<Internship,Integer> {
}