package com.example.login_resttemplete_to_flutter.userroles;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public void createRole(Role role) {

        roleRepository.save(role);
    }

    public List<Role> roleList() {

        return (List<Role>) roleRepository.findAll();
    }

    public Set<Role> getRoleByName(String rName) {
        return roleRepository.findByRoleName(rName);
    }
}
