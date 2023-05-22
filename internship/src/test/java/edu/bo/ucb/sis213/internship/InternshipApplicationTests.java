package edu.bo.ucb.sis213.internship;
import edu.bo.ucb.sis213.internship.bl.*;
import edu.bo.ucb.sis213.internship.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InternshipApplicationTests {

	@Autowired
	private RoleBl roleBl;
	@Autowired
	private PersonBl personBl;
	@Autowired
	private UserBl userBl;
	@Autowired
	private UserRoleBl userRoleBl;
	@Autowired
	private StudentBl studentBl;

	@Test
	void contextLoads() {
	}
	//Test para obtener todos los roles
	@Test
	public void getAllRole(){
		System.out.println(roleBl.findAllRoles());
	}
	//Test para obtener un rol por id
	@Test
	public void getRoleById(){
		System.out.println(roleBl.findById(1));
	}
	//Test para agregar un estudiante
	@Test
	public void addStudent(){
		//Agregar un person
		Person person = new Person();
		person.setNames("Frenkie");
		person.setFirstLastName("De Jong");
		person.setSecondLastName("Barcelona");
		Person newPerson = personBl.savePerson(person);
		//Agregar un user
		User user = new User();
		user.setMail("frenkie.jong@ucb.edu.bo");
		user.setPerson(newPerson);
		user.setPassword("12345");
		User newUser = userBl.saveUser(user);
		//Obtener el role estudiante
		Role role = roleBl.findById(1);
		//Agregar un userRole
		UserRole userRole = new UserRole();
		userRole.setUser(newUser);
		userRole.setRole(role);
		userRoleBl.saveUserRole(userRole);
		//Agregar un student
		Student student = new Student();
		student.setPerson(newPerson);


	}

}
