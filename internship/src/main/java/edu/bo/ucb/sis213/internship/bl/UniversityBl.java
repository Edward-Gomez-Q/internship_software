package edu.bo.ucb.sis213.internship.bl;
import edu.bo.ucb.sis213.internship.dao.CampusCareerRepository;
import edu.bo.ucb.sis213.internship.dao.CampusRepository;
import edu.bo.ucb.sis213.internship.dao.CareerRepository;
import edu.bo.ucb.sis213.internship.dto.CampusDto;
import edu.bo.ucb.sis213.internship.dto.CareerDto;
import edu.bo.ucb.sis213.internship.entity.Campus;
import org.mindrot.jbcrypt.BCrypt;
import edu.bo.ucb.sis213.internship.entity.Career;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UniversityBl {
    private final CampusRepository campusRepository;
    private final CampusCareerRepository campusCareerRepository;
    private final CareerRepository careerRepository;
    public UniversityBl(CampusRepository campusRepository, CampusCareerRepository campusCareerRepository, CareerRepository careerRepository) {
        this.campusRepository = campusRepository;
        this.campusCareerRepository = campusCareerRepository;
        this.careerRepository = careerRepository;
    }
    //Methods
    //Obtener todas las sedes
    public List<CampusDto> findAllCampus(){
        try {
            List<Campus> campus = campusRepository.findAll();
            List<CampusDto> campusDtoList = new ArrayList<>();
            //Convertir de Campus a CampusDto
            for (Campus campus1 : campus) {
                campusDtoList.add(new CampusDto(campus1));
            }
            return campusDtoList;
        }catch (Exception ex){
            System.out.println("Error al obtener las sedes: " + ex.getMessage());
            return null;
        }
    }
    //Obtener todas las carreras por sede
    public List<CareerDto> findAllCareersByCampus(Campus campusIdCampus){
        try {
            List<Career> careers = careerRepository.findAllCareersByCampusIdCampus(campusIdCampus.getIdCampus());
            List<CareerDto> careerDtoList = new ArrayList<>();
            //Convertir de Career a CareerDto
            for (Career career : careers) {
                careerDtoList.add(new CareerDto(career));
            }
            return careerDtoList;
        }catch (Exception ex){
            System.out.println("Error al obtener las carreras por sede: " + ex.getMessage());
            return null;
        }
    }
    // Función para comparar si dos hashes corresponden
    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
