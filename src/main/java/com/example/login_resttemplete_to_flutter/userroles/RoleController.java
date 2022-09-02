package com.example.login_resttemplete_to_flutter.userroles;

import com.ctecx.elimucloud.users.UserService;
import com.ctecx.elimucloud.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;

    }

    @GetMapping("/userRoles")
    public String registerUserRoles(Model model){

        model.addAttribute("roleUser", new Role());
        model.addAttribute("rolesData",roleService.roleList());

        return "settings/system_roles";
    }



    @PostMapping("/saveRole")
    public String saveUserRoles(Role role){

        roleService.createRole(role);
        return "redirect:/roles/userRoles";
    }

}
