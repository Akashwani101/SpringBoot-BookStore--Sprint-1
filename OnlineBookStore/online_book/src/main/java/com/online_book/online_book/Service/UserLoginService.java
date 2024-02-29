package com.online_store2.online_store2.Service;

import com.online_store2.online_store2.Entities.UserLogin;

public interface UserLoginService {
String signup(UserLogin userLogin);
String login(String email, String password);
}
