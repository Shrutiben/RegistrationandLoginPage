package com.registrationapp.registrationapp.Service;

import com.registrationapp.registrationapp.Model.UserDtls;
import com.registrationapp.registrationapp.Repository.UserRepository;
import org.apache.catalina.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDtls createUser(@NotNull UserDtls user) {
        System.out.println("Password value: " + user.getPassword());
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return  userRepo.existsByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
