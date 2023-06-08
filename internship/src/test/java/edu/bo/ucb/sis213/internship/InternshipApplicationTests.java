package edu.bo.ucb.sis213.internship;
import edu.bo.ucb.sis213.internship.bl.*;
import edu.bo.ucb.sis213.internship.dao.UseiRepository;
import edu.bo.ucb.sis213.internship.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InternshipApplicationTests {

	@Autowired
	private UniversityBl universityBl;
	@Autowired
	private UseiRepository useiRepository;
	//Test para obtener todas las sedes
	@Test
	void findAllCampus(){
		System.out.println(universityBl.findAllCampus());
	}
	@Test
	void findAllCareersByCampus(){
		Campus campus = new Campus();
		campus.setIdCampus(1);
		System.out.println(universityBl.findAllCareersByCampus(campus));
	}
	//Test para obtener un USEI por su id
	@Test
	void findUSEIById(){
		System.out.println(useiRepository.findById(1));
	}
}
