package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.UserRepository;
import edu.bo.ucb.sis213.internship.dto.LoginDto;
import edu.bo.ucb.sis213.internship.dto.TokenDto;
import edu.bo.ucb.sis213.internship.dto.UserDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthBl {
    public static final String KEY = "BarcaChampionAndMessiMasGrandeQueCR7";
    private final UserRepository userRepository;

    public AuthBl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public TokenDto login(LoginDto login){
        //get all users
        UserBl userBl = new UserBl(userRepository);
        List<UserDto> users = userBl.getAllUsers();
        //Buscar el usuario por el mail
        //Si existe, comparar la contraseña
        //Si la contraseña es correcta, generar el token
        //Si la contraseña es incorrecta, retornar un error
        //Si no existe, retornar un error
        return null;
    }

}
