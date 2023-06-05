package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dao.UserRepository;
import edu.bo.ucb.sis213.internship.entity.RoRole;
import edu.bo.ucb.sis213.internship.entity.RoUser;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import edu.bo.ucb.sis213.internship.dto.LoginDto;
import edu.bo.ucb.sis213.internship.dto.TokenDto;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuthBl {
    public static final String KEY = "BarcaChampionAndMessiMasGrandeQueCR7";
    private final UserRepository userRepository;

    public AuthBl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Login de usuario
    public TokenDto login(LoginDto login){
        //Saber si el usuario existe
        RoUser user = userRepository.findByMail(login.getEmail());
        if(user == null){
            return null;
        }
        //Crear LoginDto
        LoginDto userLogin = new LoginDto();
        userLogin.setEmail(user.getMail());
        userLogin.setPassword(user.getPassword());
        //Saber si el password es correcto
        if(!userLogin.getPassword().equals(login.getPassword())){
            return null;
        }
        //Obtener roles del usuario
        List<RoRole> roles = userRepository.findUserRolesById(user.getUserId());
        //Crear Lista de roles en forma de String
        List<String> rolesString = new ArrayList<>();
        for(RoRole role : roles){
            rolesString.add(role.getRoleName());
        }
        System.out.println("Roles del usuario: "+rolesString.toString());
        //Generar el token
        TokenDto tokenDto = new TokenDto();
        tokenDto.setAuthToken(generateToken(userLogin, "auth",rolesString, 30));
        tokenDto.setRefreshToken(generateToken(userLogin, "refresh",rolesString, 60*2));
        return tokenDto;
    }
    //Generar un token
    private String generateToken(LoginDto user, String type,List<String> roles, int minutes){
        try{
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            String token = JWT.create()
                    .withIssuer("www.ucb.edu.bo")
                    .withClaim("mail", user.getEmail())
                    .withClaim("role", roles)
                    .withClaim("type", type)
                    .withClaim("minutes", minutes)
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar el token", exception);
        }
    }
    //Validar un token
    public boolean validateToken(String token) {
        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("www.ucb.edu.bo")
                .build();
            decodedJWT = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception){
            System.err.print("Token invalido: " + exception.getMessage());
            return false;
        } 
    }
    //Obtener el mail de un token
    public String getEmailFromToken(String token){
        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("www.ucb.edu.bo")
                .build();
            decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("mail").asString();
        } catch (JWTVerificationException exception){
            System.err.print("Token invalido: " + exception.getMessage());
            return null;
        }
    }
    //Obtener la contraseña de un token
    public String getPasswordFromToken(String token){
        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("www.ucb.edu.bo")
                .build();
            decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("password").asString();
        } catch (JWTVerificationException exception){
            System.err.print("Token invalido: " + exception.getMessage());
            return null;
        }
    }
    //Obtener los roles de un token
    public List<String> getRolesFromToken(String token){
        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("www.ucb.edu.bo")
                .build();
            decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("role").asList(String.class);
        } catch (JWTVerificationException exception){
            System.err.print("Token invalido: " + exception.getMessage());
            return null;
        }
    }
}