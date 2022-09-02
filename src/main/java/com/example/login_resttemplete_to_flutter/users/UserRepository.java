package com.example.login_resttemplete_to_flutter.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User , Integer> {
    @Query("SELECT u FROM User u WHERE u.email=:email")
    User getUserByEmail(@Param("email") String email);

}
