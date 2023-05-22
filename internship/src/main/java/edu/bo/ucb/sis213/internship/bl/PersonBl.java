package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.PersonRepository;
import edu.bo.ucb.sis213.internship.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonBl {
    private final PersonRepository personRepository;
    public PersonBl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    //Aggregate a person
    public Person savePerson(Person person){
        return personRepository.save(person);
    }
    //Get a person by id
    public Person findById(int id){
        return personRepository.findById(id);
    }

}
