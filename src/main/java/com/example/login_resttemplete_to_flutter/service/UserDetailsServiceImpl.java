/**
 * Created by mupezeni for Login_rest-templete_to_flutter
 * User: mupezeni
 * Date: 1/9/2022
 * Time: 00:54
 */


package com.example.login_resttemplete_to_flutter.service;

import com.example.login_resttemplete_to_flutter.Repository.UserRepository;
import com.example.login_resttemplete_to_flutter.model.Roles;
import com.example.login_resttemplete_to_flutter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Roles roles : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(roles.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}


