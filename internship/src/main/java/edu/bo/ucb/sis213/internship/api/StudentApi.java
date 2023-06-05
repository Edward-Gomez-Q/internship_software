package edu.bo.ucb.sis213.internship.api;



import edu.bo.ucb.sis213.internship.dto.StudentDto;
import org.springframework.web.bind.annotation.*;
import edu.bo.ucb.sis213.internship.bl.StudentRegistrationBl;
import edu.bo.ucb.sis213.internship.dto.ResponseDto;


@RestController
@CrossOrigin(origins = "*")
public class StudentApi {
    private final StudentRegistrationBl studentBl;
    public StudentApi(StudentRegistrationBl studentBl){
        this.studentBl = studentBl;
    }
    @PostMapping("/api/v1/student")
    public ResponseDto<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        //Desencriptar la contraseña

        ResponseDto<StudentDto> responseDto = new ResponseDto<>();
        StudentDto studentResponse = studentBl.saveStudent(studentDto);
        if(studentResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo guardar el estudiante");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(studentResponse);
        return responseDto;
    }
}