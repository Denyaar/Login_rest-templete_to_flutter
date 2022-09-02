/**
 * Created by mupezeni for Login_rest-templete_to_flutter
 * User: mupezeni
 * Date: 1/9/2022
 * Time: 01:11
 */


package com.example.login_resttemplete_to_flutter.service;



import com.example.login_resttemplete_to_flutter.Repository.RolesRepository;
import com.example.login_resttemplete_to_flutter.Repository.UserRepository;
import com.example.login_resttemplete_to_flutter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}