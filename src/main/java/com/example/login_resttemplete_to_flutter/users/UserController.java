package com.example.login_resttemplete_to_flutter.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/users")
public class UserController {
    private  final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;


    }


    @GetMapping("/settings")
    public String registerUser(Model model){
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("userd", user);
        model.addAttribute("rolesData",userService.roleList());
        model.addAttribute("usersList",userService.userList());


        return "settings/all_users";
    }


    @PostMapping("/save")
    public String saveUser(User user)  {
        userService.createUser(user);

        return "redirect:/users/settings";
    }


}
