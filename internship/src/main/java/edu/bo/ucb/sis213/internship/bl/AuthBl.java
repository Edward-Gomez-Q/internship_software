package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dto.RoleDto;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import edu.bo.ucb.sis213.internship.dto.LoginDto;
import edu.bo.ucb.sis213.internship.dto.TokenDto;
import edu.bo.ucb.sis213.internship.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class AuthBl {
    public static final String KEY = "BarcaChampionAndMessiMasGrandeQueCR7";
    //Llamar a los bl de User, UserRole y Role
    @Autowired
    private UserBl userBl;
    @Autowired
    private RoleBl roleBl;
    //Login de usuario
    public TokenDto login(LoginDto login){
        //Saber si el usuario existe
        UserDto user = userBl.findByEmail(login.getEmail());
        if(user == null){
            return null;
        }
        //Saber si el password es correcto
        if(!user.getPassword().equals(login.getPassword())){
            return null;
        }
        //Obtener roles del usuario
        List<RoleDto> roles = userBl.findUserRolesById(user.getIdUser());
        //Generar el token
        TokenDto tokenDto = new TokenDto();
        tokenDto.setAuthToken(generateToken(user, "auth",roles, 30));
        tokenDto.setRefreshToken(generateToken(user, "refresh",roles, 60*2));
        return tokenDto;
    }
    //Generar un token
    private String generateToken(UserDto user, String type,List<RoleDto> roles, int minutes){
        try{
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            String token = JWT.create()
                    .withIssuer("www.ucb.edu.bo")
                    .withClaim("id", user.getIdUser())
                    .withClaim("mail", user.getMail())
                    .withClaim("password", user.getPassword())
                    .withClaim("role", roles)
                    .withClaim("type", type)
                    .withClaim("minutes", minutes)
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            System.out.println("Error al generar el token " + user.getIdUser() + " " + user.getMail() + " " + type + " " + minutes);
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
    public List<RoleDto> getRolesFromToken(String token){
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
            return decodedJWT.getClaim("role").asList(RoleDto.class);
        } catch (JWTVerificationException exception){
            System.err.print("Token invalido: " + exception.getMessage());
            return null;
        }
    }
    

}
