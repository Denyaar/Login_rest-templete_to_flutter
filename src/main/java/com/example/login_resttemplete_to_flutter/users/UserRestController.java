package com.example.login_resttemplete_to_flutter.users;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserRestController {
    private final UserService userService;

    @PostMapping("/users/check_mail")
    public String checkDuplicateEmail(@Param("email") String email) {


        return userService.isEmailUnique(email) ? "OK" : "Duplicate Email,Mail Already Registered";
    }
}
