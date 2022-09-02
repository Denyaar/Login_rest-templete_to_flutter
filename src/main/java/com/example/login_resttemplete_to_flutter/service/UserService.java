/**
 * Created by mupezeni for Login_rest-templete_to_flutter
 * User: mupezeni
 * Date: 1/9/2022
 * Time: 01:10
 */

package com.example.login_resttemplete_to_flutter.service;

import com.example.login_resttemplete_to_flutter.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
