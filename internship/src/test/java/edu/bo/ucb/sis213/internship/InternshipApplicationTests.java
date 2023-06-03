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
	//Test para agregar persona
	@Test
	public void savePerson(){
		Person person = new Person();
		person.setNames("Juan");
		person.setFirstLastName("Perez");
		person.setSecondLastName("Gomez");
		personBl.savePerson(person);
	}
	//Test para obtener una persona por id
	@Test
	public void getPersonById(){
		System.out.println(personBl.findById(1));
	}
	//Test para guardar un usuario
	@Test
	public void saveUser(){
		User user = new User();
		Person person = personBl.findById(1);
		user.setPerson(person);
		user.setMail("frenkie.deJong@ucb.edu.bo");
		user.setPassword("123456");
		userBl.saveUser(user);
		System.out.println(user.toString());
	}
}
