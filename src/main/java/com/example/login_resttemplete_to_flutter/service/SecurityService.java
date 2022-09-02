/**
 * Created by mupezeni for Login_rest-templete_to_flutter
 * User: mupezeni
 * Date: 1/9/2022
 * Time: 01:00
 */


package com.example.login_resttemplete_to_flutter.service;

public interface SecurityService {
    boolean isAuthenticated();

    void autoLogin(String username, String password);
}
