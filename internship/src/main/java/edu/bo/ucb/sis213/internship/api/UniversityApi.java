package edu.bo.ucb.sis213.internship.api;



import edu.bo.ucb.sis213.internship.bl.UniversityBl;
import edu.bo.ucb.sis213.internship.dto.CareerDto;
import edu.bo.ucb.sis213.internship.dto.ResponseDto;
import edu.bo.ucb.sis213.internship.dto.CampusDto;
import edu.bo.ucb.sis213.internship.entity.Campus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UniversityApi {
    private final UniversityBl universityBl;

    public UniversityApi(UniversityBl universityBl) {
        this.universityBl = universityBl;
    }
    //Api que obtiene todas las universidades
    @GetMapping("/api/v1/university/campus")
    public ResponseDto<List<CampusDto>> getUniversity (){
        ResponseDto<List<CampusDto>> responseDto = new ResponseDto<>();
        //Obtener todas las universidades
        List<CampusDto> universityDtoList = universityBl.findAllCampus();
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(universityDtoList);
        return responseDto;
    }
    //Api que obtiene todas las carreras de una universidad
    @GetMapping("/api/v1/university/{idUniversity}")
    public ResponseDto<List<CareerDto>> getCareers (@PathVariable("idUniversity") Integer id){
        ResponseDto<List<CareerDto>> responseDto = new ResponseDto<>();
        //Obtener todas las carreras de una universidad
        Campus campus = new Campus();
        campus.setIdCampus(id);
        List<CareerDto> universityDtoList = universityBl.findAllCareersByCampus(campus);
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(universityDtoList);
        return responseDto;
    }
}
