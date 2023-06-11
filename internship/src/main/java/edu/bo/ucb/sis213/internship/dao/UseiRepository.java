package edu.bo.ucb.sis213.internship.dao;
import edu.bo.ucb.sis213.internship.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.Usei;
public interface UseiRepository extends JpaRepository<Usei,Integer>{
    //Buscar Usei por id
    Usei findByIdUsei(Integer idUsei);
    //Buscar Usei por id de persona
    Usei findByPersonIdPerson(Person person);
}
