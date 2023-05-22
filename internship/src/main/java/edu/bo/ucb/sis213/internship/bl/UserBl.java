package edu.bo.ucb.sis213.internship.bl;

import edu.bo.ucb.sis213.internship.dto.UserDto;
import edu.bo.ucb.sis213.internship.entity.Person;
import edu.bo.ucb.sis213.internship.entity.User;
import org.springframework.stereotype.Service;
import edu.bo.ucb.sis213.internship.dao.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserBl {
    private final UserRepository userRepository;
    public UserBl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //get all users
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    //convert user to userDto
    private UserDto convertToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setMail(user.getMail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    //Aggregate a user
    public User saveUser(User user){
        return userRepository.save(user);
    }
}
