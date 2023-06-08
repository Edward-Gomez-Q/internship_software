package edu.bo.ucb.sis213.internship.api;

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
    public CompanyApi(CompanyBl companyBl, InternshipBl internshipBl){
        this.companyBl = companyBl;
        this.internshipBl = internshipBl;

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
    public ResponseDto<CompanyDto> getCompany(@PathVariable Integer id){
        ResponseDto<CompanyDto> responseDto = new ResponseDto<>();
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
    public ResponseDto<List<InternshipDto>> getInternships(@PathVariable Integer id){
        ResponseDto<List<InternshipDto>> responseDto = new ResponseDto<>();
        List<InternshipDto> internshipResponse = internshipBl.findAllInternshipsByCompany(id);
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
    public ResponseDto<InternshipDto> saveInternship(@PathVariable Integer id, @RequestBody InternshipDto internshipDto){
        ResponseDto<InternshipDto> responseDto = new ResponseDto<>();
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

}
