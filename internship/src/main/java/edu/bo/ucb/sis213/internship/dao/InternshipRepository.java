package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.Company;
import edu.bo.ucb.sis213.internship.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship,Integer> {
    Internship findById(int id);
    List<Internship> findAllByStatus(boolean status);
    List<Internship> findAllByCompanyIdCompany(Company company);

}
