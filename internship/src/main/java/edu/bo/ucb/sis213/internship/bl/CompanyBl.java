package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.*;
import edu.bo.ucb.sis213.internship.dto.CompanyDto;
import edu.bo.ucb.sis213.internship.entity.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompanyBl {
    private final PersonRepository personRepository;
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final GroupUserRepository groupUserRepository;
    private final ApproveCompanyRepository approveCompanyRepository;
    private final UseiRepository useiRepository;

    public CompanyBl(UseiRepository useiRepository,ApproveCompanyRepository approveCompanyRepository,PersonRepository personRepository, ContactRepository contactRepository, CompanyRepository companyRepository, GroupRepository groupRepository, UserRepository userRepository, GroupUserRepository groupUserRepository){
        this.personRepository = personRepository;
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupUserRepository = groupUserRepository;
        this.approveCompanyRepository = approveCompanyRepository;
        this.useiRepository = useiRepository;
    }

    //Agregar Información de compania
    public CompanyDto addCompany(CompanyDto companyDto){
        System.out.println("Ingreso al metodo addCompany");
        System.out.println("Datos de la compania: "+companyDto.toString());
        try {
            //Agregar datos de compania
            Company company = new Company();
            company.setNameCompany(companyDto.getNameCompany());
            company.setNit(companyDto.getNit());
            company.setReview(companyDto.getReview());
            company.setUrlIcon(companyDto.getUrlLogo());
            company.setWebsite(companyDto.getWebSide());
            company.setStatus(true);
            company.setAudDate(new Date());
            company.setAudUser("SYSTEM");
            company.setAudHost("localhost");
            companyRepository.save(company);
            //Agregar datos de persona
            Person person = new Person();
            person.setNames(companyDto.getNames());
            person.setFirstLastName(companyDto.getFirstLastName());
            person.setSecondLastName(companyDto.getSecondLastName());
            person.setDocumentPerson("");
            person.setDocumentComplemet("");
            System.out.println("Datos de persona: "+person.toString());
            personRepository.save(person);
            //Agregar Contacto
            Contact contact = new Contact();
            contact.setPersonIdPerson(person);
            contact.setCompanyIdCompany(company);
            contact.setMail(companyDto.getEmail());
            contact.setPhone(companyDto.getPhone());
            contact.setStatus(true);
            contact.setAudDate(new Date());
            contact.setAudUser("SYSTEM");
            contact.setAudHost("localhost");
            contactRepository.save(contact);
            //Agregar usuario
            RoUser user = new RoUser();
            user.setMail(companyDto.getEmail());
            user.setPassword(companyDto.getPassword());
            user.setPersonIdPerson(person);
            userRepository.save(user);
            //Guardar el grupo del estudiante
            RoGroup group = groupRepository.findByGroupName("compañia");
            GroupUser groupUser = new GroupUser();
            groupUser.setRoUserUserId(user);
            groupUser.setRoGroupIdGroup(group);
            groupUserRepository.save(groupUser);
            //Marcar a la compania en el grupo de espera
            Usei usei = useiRepository.findByIdUsei(1);
            ApproveCompany approveCompany = new ApproveCompany();
            approveCompany.setAprprove(false);
            approveCompany.setCompanyIdCompany(company);
            approveCompany.setApproveCompanyDate(new Date());
            approveCompany.setUseiIdUsei(usei);
            approveCompanyRepository.save(approveCompany);
            return new CompanyDto(company);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    //Obtener una compania por su id
    public CompanyDto findCompanyById(Integer id){
        try {
            Company company = companyRepository.findById(id).orElseThrow(()-> new Exception("No se encontro la compania"));
            return new CompanyDto(company);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
