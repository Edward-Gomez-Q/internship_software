package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.*;
import edu.bo.ucb.sis213.internship.dto.CompanyDto;
import edu.bo.ucb.sis213.internship.dto.InternshipDto;
import edu.bo.ucb.sis213.internship.dto.UseiDto;
import edu.bo.ucb.sis213.internship.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UseiBl {
    private final UseiRepository useiRepository;
    private final ApproveInternshipRepository approveInternshipRepository;
    private final ApproveCompanyRepository approveCompanyRepository;
    private  final InternshipRepository internshipRepository;
    private final CompanyRepository companyRepository;
    UseiBl(InternshipRepository internshipRepository, CompanyRepository companyRepository,  UseiRepository useiRepository, ApproveInternshipRepository approveInternshipRepository, ApproveCompanyRepository approveCompanyRepository){
        this.useiRepository = useiRepository;
        this.approveInternshipRepository = approveInternshipRepository;
        this.approveCompanyRepository = approveCompanyRepository;
        this.internshipRepository = internshipRepository;
        this.companyRepository = companyRepository;
    }
    //Obtener un Usei por su id
    public UseiDto findById(Integer id){
        Usei usei = useiRepository.findByIdUsei(id);
        UseiDto useiDto = new UseiDto(usei);
        return useiDto;
    }
    //Obtener todas las pasantías que quieren ser aprobadas
    public List<InternshipDto> findAllInternshipApprove(){
        List<ApproveInternship> internships = approveInternshipRepository.findAllByAprprove(false);
        List<InternshipDto> internshipDtos = new ArrayList<>();
        for (ApproveInternship internship : internships){
            InternshipDto internshipDto = new InternshipDto(internship.getInternshipIdInternship());
            internshipDtos.add(internshipDto);
        }
        return internshipDtos;
    }
    //Obtener todas las compañías que quieren ser aprobadas
    public List<CompanyDto> findAllCompanyApprove(){
        List<ApproveCompany> companies = approveCompanyRepository.findAllByAprprove(false);
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (ApproveCompany company : companies){
            CompanyDto companyDto = new CompanyDto(company.getCompanyIdCompany());
            companyDtos.add(companyDto);
        }
        return companyDtos;
    }
    //Aprobar una pasantía
    public InternshipDto approveInternship(int idInternship){
        Internship internship = internshipRepository.findById(idInternship);
        internship.setStatus(true);
        internshipRepository.save(internship);
        ApproveInternship approveInternship = approveInternshipRepository.findByInternshipIdInternship(internship);
        approveInternship.setAprprove(true);
        approveInternshipRepository.save(approveInternship);
        InternshipDto internshipDto = new InternshipDto(internship);
        return internshipDto;
    }
    //Aprobar una compañía
    public CompanyDto approveCompany(int idCompany){
        ApproveCompany approveCompany = approveCompanyRepository.findByCompanyIdCompany(idCompany);
        approveCompany.setAprprove(true);
        approveCompanyRepository.save(approveCompany);
        Company company = companyRepository.findById(idCompany);
        company.setStatus(true);
        companyRepository.save(company);
        CompanyDto companyDto = new CompanyDto(approveCompany.getCompanyIdCompany());
        return companyDto;
    }
    //Recharzar una pasantía
    public InternshipDto rejectInternship(int idInternship){
        Internship internship = internshipRepository.findById(idInternship);
        internship.setStatus(false);
        internshipRepository.save(internship);
        ApproveInternship approveInternship = approveInternshipRepository.findByInternshipIdInternship(internship);
        approveInternshipRepository.delete(approveInternship);
        InternshipDto internshipDto = new InternshipDto(internship);
        return internshipDto;
    }
    //Recharzar una compañía
    public CompanyDto rejectCompany(int idCompany){
        ApproveCompany approveCompany = approveCompanyRepository.findByCompanyIdCompany(idCompany);
        approveCompanyRepository.delete(approveCompany);
        Company company = companyRepository.findById(idCompany);
        companyRepository.delete(company);
        CompanyDto companyDto = new CompanyDto(approveCompany.getCompanyIdCompany());
        return companyDto;
    }
}
