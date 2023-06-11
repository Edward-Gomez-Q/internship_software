package edu.bo.ucb.sis213.internship.api;

import edu.bo.ucb.sis213.internship.bl.AuthBl;
import edu.bo.ucb.sis213.internship.bl.CompanyBl;
import edu.bo.ucb.sis213.internship.bl.InternshipBl;
import edu.bo.ucb.sis213.internship.dto.CompanyDto;
import edu.bo.ucb.sis213.internship.dto.InternshipDto;
import edu.bo.ucb.sis213.internship.dto.ResponseDto;
import edu.bo.ucb.sis213.internship.entity.Company;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CompanyApi {
    private final CompanyBl companyBl;
    private final InternshipBl internshipBl;
    private final AuthBl authBl;
    public CompanyApi(CompanyBl companyBl, InternshipBl internshipBl, AuthBl authBl){
        this.companyBl = companyBl;
        this.internshipBl = internshipBl;
        this.authBl = authBl;

    }
    //Api para guardar una empresa
    @PostMapping("/api/v1/company")
    public ResponseDto<CompanyDto> saveCompany(@RequestBody CompanyDto company){
        System.out.println("Nombre del contacto: "+company.getNames());
        ResponseDto<CompanyDto> responseDto = new ResponseDto<>();
        CompanyDto companyResponse = companyBl.addCompany(company);
        if(companyResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo guardar la empresa");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(companyResponse);
        return responseDto;
    }
    //Api para obtener una empresa por su id
    @GetMapping("/api/v1/company/{id}")
    public ResponseDto<CompanyDto> getCompany(@RequestHeader("Authorization") String token, @PathVariable Integer id){
        ResponseDto<CompanyDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        CompanyDto companyResponse = companyBl.findCompanyById(id);
        if(companyResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener la empresa");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(companyResponse);
        return responseDto;
    }
    //Api para obtener todas las pasantias de una empresa
    @GetMapping("/api/v1/company/{id}/internship")
    public ResponseDto<List<InternshipDto>> getInternships(@RequestHeader("Authorization") String token, @PathVariable Integer id){
        ResponseDto<List<InternshipDto>> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        List<InternshipDto> internshipResponse = internshipBl.findAllInternshipsByCompanyAndStatus(id,true);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener la empresa");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
    //Api para guardar una pasantia
    @PostMapping("/api/v1/company/{id}/internship")
    public ResponseDto<InternshipDto> saveInternship(@RequestHeader("Authorization") String token, @PathVariable Integer id, @RequestBody InternshipDto internshipDto){
        System.out.println("Internship: "+internshipDto.toString());
        ResponseDto<InternshipDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        InternshipDto internshipResponse = internshipBl.addInternship(internshipDto,id);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo guardar la pasantia");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
    //Api para actualizar una pasantia
    @PutMapping("/api/v1/company/{id}/internship/{idInternship}")
    public ResponseDto<InternshipDto> updateInternship(@RequestHeader("Authorization") String token, @PathVariable Integer id, @PathVariable Integer idInternship, @RequestBody InternshipDto internshipDto){
        System.out.println("Internship: "+internshipDto.toString());
        ResponseDto<InternshipDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        InternshipDto internshipResponse = internshipBl.updateInternship(internshipDto,id);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo actualizar la pasantia");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
    //Api para saber si una compañia fue aceptada
    @GetMapping("/api/v1/company/{id}/status")
    public ResponseDto<Boolean> getStatus(@RequestHeader("Authorization") String token, @PathVariable Integer id){
        ResponseDto<Boolean> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        Boolean status = companyBl.findStatusCompany(id);
        if(status==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener el estado de la empresa");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(status);
        return responseDto;
    }

}
