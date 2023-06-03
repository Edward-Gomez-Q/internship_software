package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Student;

import java.time.Instant;
import java.util.Date;

public class StudentDto {
    private int id_student;
    private PersonDto personDto;
    private DocumentDto documentDto;
    private CareerDto career;
    private boolean graduated;
    private String year_of_income;
    private String aud_host;
    //Builder
    public StudentDto() {
    }

    public StudentDto(int id_student, PersonDto personDto, DocumentDto documentDto, CareerDto career, boolean graduated, String year_of_income,String aud_host, UserDto userDto){
        this.id_student = id_student;
        this.personDto = personDto;
        this.documentDto = documentDto;
        this.career = career;
        this.graduated = graduated;
        this.year_of_income = year_of_income;
        this.aud_host= aud_host;
    }
    public StudentDto(Student student){
        this.id_student = student.getStudentId();
        this.personDto = new PersonDto(student.getPerson());
        this.documentDto = new DocumentDto(student.getDocument());
        this.career = new CareerDto(student.getCareer());
        this.graduated = student.getGraduate();
        this.year_of_income = student.getYearOfIncome();
        this.aud_host= student.getAudHost();
    }

    //Funcion para convertir de StudentDto a Student
    public Student toStudent(StudentDto studentDto, boolean status){
        Student student = new Student();
        student.setStudentId(studentDto.getId_student());
        student.setDocument(studentDto.getDocumentDto().toDocument());
        student.setCareer(studentDto.getCareer().toCareer());
        student.setGraduate(studentDto.isGraduated());
        student.setYearOfIncome(studentDto.getYear_of_income());
        student.setStatus(status);
        student.setAudHost(studentDto.getAud_host());
        student.setAudDate(Date.from(Instant.now()));
        student.setAudUser(String.valueOf(studentDto.getPersonDto().getId_person()));
        student.setPerson(studentDto.getPersonDto().toPerson());
        return student;
    }


    @Override
    public String toString() {
        return "StudentDto{" +
                "id_student=" + id_student +
                ", personDto=" + personDto +
                ", documentDto=" + documentDto +
                ", career=" + career +
                ", graduated=" + graduated +
                ", year_of_income='" + year_of_income + '\'' +
                '}';
    }

    //Getters and Setters
    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public DocumentDto getDocumentDto() {
        return documentDto;
    }

    public void setDocumentDto(DocumentDto documentDto) {
        this.documentDto = documentDto;
    }

    public CareerDto getCareer() {
        return career;
    }

    public void setCareer(CareerDto career) {
        this.career = career;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public String getYear_of_income() {
        return year_of_income;
    }

    public void setYear_of_income(String year_of_income) {
        this.year_of_income = year_of_income;
    }

    public String getAud_host() {
        return aud_host;
    }

    public void setAud_host(String aud_host) {
        this.aud_host = aud_host;
    }
}

