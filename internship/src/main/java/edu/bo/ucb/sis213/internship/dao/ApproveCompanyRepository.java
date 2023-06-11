package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.ApproveCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApproveCompanyRepository extends JpaRepository<ApproveCompany,Integer>{
    List<ApproveCompany> findAllByAprprove(boolean aprprove);
    ApproveCompany findByCompanyIdCompany(int id);

}
