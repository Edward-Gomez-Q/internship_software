package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.*;
import edu.bo.ucb.sis213.internship.dto.StudentDto;
import edu.bo.ucb.sis213.internship.entity.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentBl {
    public static final String KEY = "BarcaChampionAndMessiMasGrandeQueCR7";
    private final StudentRepository studentRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final CareerRepository careerRepository;
    private final GroupUserRepository groupUserRepository;
    private final GroupRepository groupRepository;

    //Constructor de la clase
    public StudentBl(StudentRepository studentRepository, PersonRepository personRepository, UserRepository userRepository, CareerRepository careerRepository, GroupUserRepository groupUserRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.personRepository = personRepository;
        this.userRepository = userRepository;
        this.careerRepository = careerRepository;
        this.groupUserRepository = groupUserRepository;
        this.groupRepository = groupRepository;
    }

    //Agregrar un estudiante
    public StudentDto saveStudent(StudentDto newStudent){
        System.out.println("Ingreso al metodo saveStudent");
        System.out.println("Datos del estudiante: "+newStudent.toString());
        try {
            //Crear un objeto de tipo Person
            Person person = new Person();
            person.setNames(newStudent.getNombres());
            person.setFirstLastName(newStudent.getPrimerApellido());
            person.setSecondLastName(newStudent.getSegundoApellido());
            person.setDocumentPerson(newStudent.getNumeroDocumento());
            person.setDocumentComplemet(newStudent.getDepartamento());
            //Guardar la persona
            personRepository.save(person);
            //Crear un objeto de tipo User
            RoUser user = new RoUser();
            user.setMail(newStudent.getCorreoElectronico());
            user.setPassword(newStudent.getContrasena());
            user.setPersonIdPerson(person);
            //Guardar el usuario
            userRepository.save(user);
            //Crear un objeto de tipo Career
            Career career = careerRepository.findByCareerName(newStudent.getCarrera());
            //Crear un objeto de tipo Student
            Student student = new Student();
            student.setCareerIdCarrer(career);
            student.setPersonIdPerson(person);
            student.setGraduate(newStudent.isValidacionUCB());
            student.setYearOfIncome(newStudent.getAnioIngreso());
            student.setStatus(true);
            student.setAudDate(new Date());
            student.setAudUser("SYSTEM");
            student.setAudHost("localhost");
            //Guardar el estudiante
            studentRepository.save(student);
            //Guardar el grupo del estudiante
            RoGroup group = groupRepository.findByGroupName("estudiante");
            GroupUser groupUser = new GroupUser();
            groupUser.setRoUserUserId(user);
            groupUser.setRoGroupIdGroup(group);
            groupUserRepository.save(groupUser);
            return new StudentDto(student);
        }catch (Exception e){
            System.out.println("Error al guardar el estudiante: "+e.getMessage());
            return null;
        }
    }
    //Buscar un estudiante por su correo
    public StudentDto findStudentByEmail(String email){
        try {
            RoUser user = userRepository.findByMail(email);
            Student student = studentRepository.findByPersonIdPerson(user.getPersonIdPerson());
            return new StudentDto(student);
        }catch (Exception e){
            System.out.println("Error al buscar el estudiante: "+e.getMessage());
            return null;
        }
    }
    //Buscar un estudiante por su id
    public StudentDto findStudentById(int id){
        try {
            Student student = studentRepository.findById(id);
            return new StudentDto(student);
        }catch (Exception e){
            System.out.println("Error al buscar el estudiante: "+e.getMessage());
            return null;
        }
    }
    //Buscar estudiante por su person
    public StudentDto findStudentByPerson(Person person){
        try {
            Student student = studentRepository.findByPersonIdPerson(person);
            return new StudentDto(student);
        }catch (Exception e){
            System.out.println("Error al buscar el estudiante: "+e.getMessage());
            return null;
        }
    }
}
