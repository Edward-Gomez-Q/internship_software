package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.PersonRepository;
import edu.bo.ucb.sis213.internship.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonBl {
    @Autowired
    private  PersonRepository personRepository;
    //Aggregate a person
    public Person savePerson(Person person){
        return personRepository.save(person);
    }
    //Get a person by id
    public Person findById(int id){
        return personRepository.findById(id);
    }
    

}
