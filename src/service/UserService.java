package service;

import java.sql.SQLException;

import dto.UserSignInDto;
import dto.UserSignUpDto;
import repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(){
        userRepository = new UserRepository();
    }


    public int userSignIn(UserSignInDto userSignInDto) throws ClassNotFoundException, SQLException {
      return userRepository.findUser(userSignInDto);
    }


    public int userSignUpService(UserSignUpDto newUser) throws ClassNotFoundException, SQLException {
        return userRepository.save(newUser);
    }


    
}
