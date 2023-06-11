package edu.bo.ucb.sis213.internship.dao;
import edu.bo.ucb.sis213.internship.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.bo.ucb.sis213.internship.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>{
    //Buscar por id de persona
    public Contact findByPersonIdPerson(Person person);
}
