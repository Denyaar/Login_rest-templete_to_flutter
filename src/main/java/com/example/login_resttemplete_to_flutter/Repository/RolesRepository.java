/**
 * Created by mupezeni for Login_rest-templete_to_flutter
 * User: mupezeni
 * Date: 30/8/2022
 * Time: 22:24
 */


package com.example.login_resttemplete_to_flutter.Repository;

import com.example.login_resttemplete_to_flutter.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
