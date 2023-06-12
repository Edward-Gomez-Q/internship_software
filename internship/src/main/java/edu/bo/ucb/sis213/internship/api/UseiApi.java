package edu.bo.ucb.sis213.internship.api;

import edu.bo.ucb.sis213.internship.bl.AuthBl;
import edu.bo.ucb.sis213.internship.bl.UseiBl;
import edu.bo.ucb.sis213.internship.dto.CompanyDto;
import edu.bo.ucb.sis213.internship.dto.InternshipDto;
import edu.bo.ucb.sis213.internship.dto.ResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UseiApi {
    private final UseiBl useiBl;
    private final AuthBl authBl;
    public UseiApi(UseiBl useiBl, AuthBl authBl) {
        this.useiBl = useiBl;
        this.authBl = authBl;
    }
    //Api para obtener todas las pasantías que quieran ser aprobadadas
    @GetMapping("/api/v1/usei/{id}/internship/approve")
    public ResponseDto<List<InternshipDto>> getInternship (@RequestHeader("Authorization") String token, @PathVariable Integer id){
        ResponseDto<List<InternshipDto>> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        //Obtener todas las pasantías que quieran ser aprobadadas
        List<InternshipDto> internshipDtoList = useiBl.findAllInternshipApprove();
        if(internshipDtoList==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener la lista");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipDtoList);
        return responseDto;
    }
    @GetMapping("/api/v1/usei/{id}/company/approve")
    public ResponseDto<List<CompanyDto>> getCompany (@RequestHeader("Authorization") String token, @PathVariable Integer id){
        ResponseDto<List<CompanyDto>> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        //Obtener todas las companias que quieran ser aprobadas
        List<CompanyDto> internshipDtoList = useiBl.findAllCompanyApprove();
        if(internshipDtoList==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo obtener la lista");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipDtoList);
        return responseDto;
    }
    //Api para aprobar una pasantía
    @PutMapping("/api/v1/usei/{id}/internship/{idInternship}")
    public ResponseDto<InternshipDto> approveInternship(@RequestHeader("Authorization") String token, @PathVariable Integer id, @PathVariable Integer idInternship){
        ResponseDto<InternshipDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        InternshipDto internshipResponse = useiBl.approveInternship(idInternship);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo aprobar la pasantía");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
    //Api para rechazar una pasantía
    @PutMapping("/api/v1/usei/{id}/internship/{idInternship}/reject")
    public ResponseDto<InternshipDto> rejectInternship(@RequestHeader("Authorization") String token, @PathVariable Integer id, @PathVariable Integer idInternship){
        ResponseDto<InternshipDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        InternshipDto internshipResponse = useiBl.rejectInternship(idInternship);
        if(internshipResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo rechazar la pasantía");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(internshipResponse);
        return responseDto;
    }
    //Api para obtener todas las companias que quieran ser aprobadas

    //Api para aprobar una compania
    @PutMapping("/api/v1/usei/{id}/company/{idCompany}")
    public ResponseDto<CompanyDto> approveCompany(@RequestHeader("Authorization") String token, @PathVariable Integer id, @PathVariable Integer idCompany){
        ResponseDto<CompanyDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        CompanyDto companyResponse = useiBl.approveCompany(idCompany);
        if(companyResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo aprobar la compania");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(companyResponse);
        return responseDto;
    }
    //Api para rechazar una compania
    @PutMapping("/api/v1/usei/{id}/company/{idCompany}/reject")
    public ResponseDto<CompanyDto> rejectCompany(@RequestHeader("Authorization") String token, @PathVariable Integer id, @PathVariable Integer idCompany){
        ResponseDto<CompanyDto> responseDto = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            responseDto.setCode("200");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Invalid token");
            return responseDto;
        }
        System.out.println("idCompany: "+idCompany);
        CompanyDto companyResponse = useiBl.rejectCompany(idCompany);
        if(companyResponse==null){
            responseDto.setCode("400");
            responseDto.setErrorMessage("No se pudo rechazar la compania");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(companyResponse);
        return responseDto;
    }

}
