package edu.bo.ucb.sis213.internship.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.Person;
public interface PersonRepository extends JpaRepository<Person,Integer>{
    //Obtener una persona por su id
    Person findById(int id);
}
