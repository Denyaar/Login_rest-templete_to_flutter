package com.example.login_resttemplete_to_flutter.userroles;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role ,Integer> {

    //List<Role> findByRoleName(String roleName);
    Set<Role> findByRoleName(String roleName);
}
