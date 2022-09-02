package com.example.login_resttemplete_to_flutter.users;

import com.ctecx.elimucloud.userroles.Role;
import com.ctecx.elimucloud.userroles.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public void createUser(User user) {
        encodePassword(user);
        userRepository.save(user);

    }

    public List<User> userList() {

        return (List<User>) userRepository.findAll();
    }

    public List<Role> roleList() {
        return (List<Role>) roleRepository.findAll();
    }

    private void encodePassword(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    public boolean isEmailUnique(String email) {
      User  userBymail=  userRepository.getUserByEmail(email);

      return userBymail==null;
    }
}
