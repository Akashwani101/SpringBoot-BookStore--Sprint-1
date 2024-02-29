package com.onlinebookstore.onlinebookstore.Service;

import com.onlinebookstore.onlinebookstore.Entities.UserLogin;

public interface UserLoginService {
String signup(UserLogin userLogin);
String login(String email, String password);
}
