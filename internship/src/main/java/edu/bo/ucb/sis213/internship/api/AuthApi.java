package edu.bo.ucb.sis213.internship.api;

import edu.bo.ucb.sis213.internship.bl.AuthBl;
import edu.bo.ucb.sis213.internship.dto.LoginDto;
import edu.bo.ucb.sis213.internship.dto.ResponseDto;
import edu.bo.ucb.sis213.internship.dto.TokenDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthApi {
    private final AuthBl authBl;
    public AuthApi(AuthBl authBl){
        this.authBl = authBl;
    }

    @PostMapping("/api/v1/auth/login")
    public ResponseDto<TokenDto> login (@RequestBody LoginDto login)
    {
        ResponseDto<TokenDto> responseDto = new ResponseDto<>();
        TokenDto tokenDto = authBl.login(login);
        if(tokenDto==null)
        {
            responseDto.setCode("401");
            responseDto.setErrorMessage("Usuario o contraseña incorrectos");
            responseDto.setResponse(null);
            return responseDto;
        }
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(tokenDto);
        return responseDto;
    }
}
