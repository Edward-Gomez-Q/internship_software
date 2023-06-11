package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.*;
import edu.bo.ucb.sis213.internship.dto.InternshipDto;
import edu.bo.ucb.sis213.internship.entity.*;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InternshipBl {
    private final InternshipRepository internshipRepository;
    private final CompanyRepository companyRepository;
    private final CarrerInternshipRepository carrerInternshipRepository;
    private final CareerRepository careerRepository;

    private final StudentRepository studentRepository;
    private final ApproveInternshipRepository approveInternshipRepository;
    private final UseiRepository useiRepository;

    InternshipBl(ApproveInternshipRepository approveInternshipRepository ,StudentRepository studentRepository,InternshipRepository internshipRepository, CompanyRepository companyRepository, CarrerInternshipRepository carrerInternshipRepository, CareerRepository careerRepository, UseiRepository useiRepository){
        this.approveInternshipRepository = approveInternshipRepository;
        this.internshipRepository = internshipRepository;
        this.companyRepository = companyRepository;
        this.carrerInternshipRepository = carrerInternshipRepository;
        this.careerRepository = careerRepository;
        this.studentRepository = studentRepository;
        this.useiRepository = useiRepository;
    }
    //Agregar un nuevo internship
    public InternshipDto addInternship(InternshipDto internshipDto, int idCompany) {
        //Obtener la compañia por id
        Company company = companyRepository.findById(idCompany);
        Internship internship = new Internship();
        internship.setTitle(internshipDto.getTitle());
        internship.setCity(internshipDto.getDepartment());
        internship.setDeadline(internshipDto.getDeadline());
        internship.setDays(internshipDto.getDays());
        internship.setDuration(internshipDto.getDuration());
        internship.setStartTimeInternship(internshipDto.getStartDate());
        internship.setEndTimeInternship(internshipDto.getEndDate());
        internship.setDescription(internshipDto.getDescription());
        internship.setUlrDescription(internshipDto.getUrlPDF());
        internship.setCompanyIdCompany(company);
        internship.setUrlSyllable(internshipDto.getUrlWORD());
        internship.setKnowledge(internshipDto.getKnowledge());
        internship.setStatus(false);
        internship.setAudDate(new Date());
        internship.setAndUser("SYSTEM");
        internship.setAudHost("localhost");
        internshipRepository.save(internship);
        //Marcar pasantía en el estado de aprobación de la compañía
        Usei usei = useiRepository.findByIdUsei(1);
        ApproveInternship approveInternship = new ApproveInternship();
        approveInternship.setApproveInternshipDate(new Date());
        approveInternship.setAprprove(false);
        approveInternship.setUseiIdUsei(usei);
        approveInternship.setInternshipIdInternship(internship);
        approveInternshipRepository.save(approveInternship);
        //Guardar las carreras que se relacionan con el internship
        List<String> careers = internshipDto.getCareers();
        for (int i = 0; i < internshipDto.getCareers().size(); i++) {
            Career career = careerRepository.findByCareerName(careers.get(i));
            CarrerInternship carrerInternship = new CarrerInternship();
            carrerInternship.setCareerIdCarrer(career);
            carrerInternship.setInternshipIdInternship(internship);
            carrerInternshipRepository.save(carrerInternship);
        }
        return new InternshipDto(internship);
    }
    //Obtener todos los internships con status
    public List<InternshipDto> findAllInternships(boolean status, int idStudent){
        Career career = studentRepository.findById(idStudent).getCareerIdCarrer();
        List<InternshipDto> result=new ArrayList<>();
        List<Internship> internships = internshipRepository.findAllByStatus(status);
        //Convertir la lista de internships a una lista de internshipsDto
        for (int i = 0; i < internships.size(); i++) {
            InternshipDto internshipDto = new InternshipDto(internships.get(i));
            result.add(internshipDto);
        }
        //Poner las pasantías de la carrera del estudiante en la primera posición
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).getCareers().contains(career)){
                InternshipDto internshipDto = result.get(i);
                result.remove(i);
                result.add(0,internshipDto);
            }
        }
        return result;
    }
    //Obtener todas las pasantías por compañia
    public List<InternshipDto> findAllInternshipsByCompany(int idCompany){
        List<InternshipDto> result=new ArrayList<>();
        Company company = companyRepository.findById(idCompany);
        List<Internship> internships = internshipRepository.findAllByCompanyIdCompany(company);
        //Convertir la lista de internships a una lista de internshipsDto
        for (int i = 0; i < internships.size(); i++) {
            InternshipDto internshipDto = new InternshipDto(internships.get(i));
            result.add(internshipDto);
        }
        return result;
    }
    //Obtener una pasantía por id
    public InternshipDto findInternshipById(int id){
        Internship internship = internshipRepository.findById(id);
        InternshipDto internshipDto = new InternshipDto(internship);
        return internshipDto;
    }
    public Date convertirStringADate(String fechaString) throws ParseException {
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return formatoFecha.parse(fechaString);
    }

    public long convertirStringATimestamp(String fechaString) throws ParseException {
        Date fecha = convertirStringADate(fechaString);
        return fecha.getTime();
    }
    //Obtener todas las pasantías en espera de aprobación
    public List<InternshipDto> findAllInternshipsByStatus(boolean status){
        List<InternshipDto> result=new ArrayList<>();
        List<Internship> internships = internshipRepository.findAllByStatus(status);
        //Convertir la lista de internships a una lista de internshipsDto
        for (int i = 0; i < internships.size(); i++) {
            InternshipDto internshipDto = new InternshipDto(internships.get(i));
            result.add(internshipDto);
        }
        return result;
    }

}
