package edu.bo.ucb.sis213.internship.api;


import edu.bo.ucb.sis213.internship.bl.AuthBl;
import edu.bo.ucb.sis213.internship.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bo.ucb.sis213.internship.bl.StudentBl;
import edu.bo.ucb.sis213.internship.dto.ResponseDto;


@RestController
@CrossOrigin(origins = "*")
public class StudentApi {
    @Autowired
    private StudentBl studentBl;
    /*
    * Api para dar de alta un estudiante
    * */
    @PostMapping("/api/v1/student")
    public ResponseDto saveStudent(@RequestBody StudentDto studentDto, @RequestHeader("Authorization") String token){
        ResponseDto responseDto = new ResponseDto();
        AuthBl authBl = new AuthBl();
        if(!authBl.validateToken(token)){
            responseDto.setCode("401");
            responseDto.setErrorMessage("No autorizado");
            responseDto.setResponse(null);
            return responseDto;
        }
        StudentDto studentResponse = studentBl.saveStudent(studentDto,token);
        if(studentResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo guardar el estudiante");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse("Estudiante guardado correctamente");
        return responseDto;
    }
}
