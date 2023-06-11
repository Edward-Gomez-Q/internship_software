package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.Company;
import edu.bo.ucb.sis213.internship.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship,Integer> {
    Internship findById(int id);
    List<Internship> findAllByStatus(boolean status);
    List<Internship> findAllByCompanyIdCompany(Company company);
    List<Internship> findAllByStatusAndCompanyIdCompany(boolean status, Company company);
    /*
            SELECT *
        FROM internship
        WHERE id_internship NOT IN (
            SELECT internship_id_internship
            FROM postulation
            WHERE student_id_student = idStudent
        );
     */
    @Query("SELECT i FROM Internship i " +
            "WHERE i.idInternship NOT IN " +
            "(SELECT p.internshipIdInternship.idInternship FROM Postulation p " +
            "WHERE p.studentIdStudent.idStudent = :idStudent)")
    List<Internship> findInternshipsWithoutPostulationByStudentId(@Param("idStudent") int idStudent);

}
