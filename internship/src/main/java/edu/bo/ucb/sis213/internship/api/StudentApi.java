package edu.bo.ucb.sis213.internship.api;



import edu.bo.ucb.sis213.internship.bl.AuthBl;
import edu.bo.ucb.sis213.internship.bl.InternshipBl;
import edu.bo.ucb.sis213.internship.dto.InternshipDto;
import edu.bo.ucb.sis213.internship.dto.StudentDto;
import org.springframework.web.bind.annotation.*;
import edu.bo.ucb.sis213.internship.bl.StudentBl;
import edu.bo.ucb.sis213.internship.dto.ResponseDto;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class StudentApi {
    private final StudentBl studentBl;
    private final InternshipBl internshipBl;
    private final AuthBl authBl;

    public StudentApi(StudentBl studentBl, InternshipBl internshipBl, AuthBl authBl){
        this.studentBl = studentBl;
        this.internshipBl = internshipBl;
        this.authBl = authBl;
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
    @GetMapping("/api/v1/student/{id}")
    public ResponseDto<StudentDto> getStudent(@RequestHeader("Authorization") String token,@PathVariable Integer id){
        ResponseDto<StudentDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        StudentDto studentResponse = studentBl.findStudentById(id);
        if(studentResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener el estudiante");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(studentResponse);
        return responseDto;
    }
    //Api para obtener todas las pasantias disponibles
    @GetMapping("/api/v1/student/{id}/internship")
    public ResponseDto<List<InternshipDto>> getInternships(@RequestHeader("Authorization") String token,@PathVariable Integer id){
        ResponseDto<List<InternshipDto>> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        List<InternshipDto> internshipResponse = internshipBl.findAllInternshipsAvailable(id);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener las pasantias");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
    //Api para obtener una pasantia por su id
    @GetMapping("/api/v1/student/{id}/internship/{idInternship}")
    public ResponseDto<InternshipDto> getInternship(@RequestHeader("Authorization") String token,@PathVariable Integer id, @PathVariable Integer idInternship){
        ResponseDto<InternshipDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        InternshipDto internshipResponse = internshipBl.findInternshipById(idInternship);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener la pasantia");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
    //Api para postularse a una pasantia
    @PostMapping("/api/v1/student/{id}/internship/{idInternship}")
    public ResponseDto<String> applyInternship(@RequestHeader("Authorization") String token,@PathVariable Integer id, @PathVariable Integer idInternship){
        ResponseDto<String> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        String internshipResponse = studentBl.applyInternship(id,idInternship);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo aplicar a la pasantia");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
}