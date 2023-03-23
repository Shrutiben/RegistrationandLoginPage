package com.registrationapp.registrationapp.Service;

import com.registrationapp.registrationapp.Model.UserDtls;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);

    User getUserByUsername(String username);
}
