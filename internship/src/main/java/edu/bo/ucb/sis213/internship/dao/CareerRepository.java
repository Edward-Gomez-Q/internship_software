package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career,Integer> {

    //Query para obtener todas las carreras por sede
    @Query(value = "SELECT * FROM career c INNER JOIN campus_career cc ON c.id_carrer = cc.career_id_carrer WHERE cc.campus_id_campus = ?1",nativeQuery = true)
    public List<Career> findAllCareersByCampusIdCampus(int campusIdCampus);
    //Query para obtener carreras por nombre
    @Query(value = "SELECT * FROM career WHERE career_name = ?1",nativeQuery = true)
    public Career findByCareerName(String careerName);
}
