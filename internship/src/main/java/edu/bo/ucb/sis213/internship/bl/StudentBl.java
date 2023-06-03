package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.DocumentRepository;
import edu.bo.ucb.sis213.internship.dao.PersonRepository;
import edu.bo.ucb.sis213.internship.dao.StudentRepository;
import edu.bo.ucb.sis213.internship.dao.UserRepository;
import edu.bo.ucb.sis213.internship.dto.DocumentDto;
import edu.bo.ucb.sis213.internship.dto.PersonDto;
import edu.bo.ucb.sis213.internship.dto.StudentDto;
import edu.bo.ucb.sis213.internship.dto.UserDto;
import edu.bo.ucb.sis213.internship.entity.Document;
import edu.bo.ucb.sis213.internship.entity.Person;
import edu.bo.ucb.sis213.internship.entity.Student;
import edu.bo.ucb.sis213.internship.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBl {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentRepository documentRepository;

    //Agregrar un estudiante
    public StudentDto saveStudent(StudentDto newStudent,String token){
        try {
            StudentDto studentDto = new StudentDto();
            studentDto.setGraduated(newStudent.isGraduated());
            studentDto.setYear_of_income(newStudent.getYear_of_income());
            studentDto.setAud_host(newStudent.getAud_host());
            AuthBl authBl = new AuthBl();
            //Guardar a la persona
            Person person = personRepository.save(newStudent.getPersonDto().toPerson());
            studentDto.setPersonDto(new PersonDto(person));
            //Guardar el documento
            Document document = documentRepository.save(newStudent.getDocumentDto().toDocument());
            studentDto.setDocumentDto(new DocumentDto(document));
            //Guardar al estudiante
            Student student = studentRepository.save(newStudent.toStudent(newStudent,true));
            //Guardar el usuario
            UserDto userDto = new UserDto();
            userDto.setPersonDto(newStudent.getPersonDto());
            userDto.setMail(authBl.getEmailFromToken(token));
            userDto.setPassword(authBl.getPasswordFromToken(token));
            User user = userRepository.save(userDto.toUser());
            return studentDto;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //get a student by id
    public Student findById(int id){
        return studentRepository.findById(id);
    }
}
