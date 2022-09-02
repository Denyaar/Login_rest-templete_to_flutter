package com.example.login_resttemplete_to_flutter.security;



import com.example.login_resttemplete_to_flutter.users.User;
import com.example.login_resttemplete_to_flutter.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class RestDetailsService implements UserDetailsService {
     @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user= userRepository.getUserByEmail(email);

       if(user !=null){

           return  new RestUserDetails(user);
       }

        throw new UsernameNotFoundException("Could Not Find User with email:"+email);
    }
}
