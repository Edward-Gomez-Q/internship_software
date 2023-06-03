package edu.bo.ucb.sis213.internship.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.Student;
public interface StudentRepository extends JpaRepository<Student,Integer>{
    //Obtener un estudiante por su id
    Student findById(int id);
}
