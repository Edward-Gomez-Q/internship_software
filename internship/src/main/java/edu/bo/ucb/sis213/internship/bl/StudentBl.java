package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.StudentRepository;
import edu.bo.ucb.sis213.internship.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentBl {
    private final StudentRepository studentRepository;
    //Constructor
    public StudentBl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    //aggregate a student
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    //get a student by id
    public Student findById(int id){
        return studentRepository.findById(id);
    }
}
