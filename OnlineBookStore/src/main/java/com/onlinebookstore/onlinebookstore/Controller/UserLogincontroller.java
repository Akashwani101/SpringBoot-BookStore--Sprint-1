package com.onlinebookstore.onlinebookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.onlinebookstore.Entities.UserLogin;
import com.onlinebookstore.onlinebookstore.Service.UserLoginService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/userlogin")
public class UserLogincontroller {
@Autowired
UserLoginService userLoginService;

@PostMapping("/signup")
public String signup(@RequestBody UserLogin userLogin)
{
	return userLoginService.signup(userLogin);
}

@GetMapping("/search/{email}/{password}")
public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password)
{
	return ResponseEntity.ok(userLoginService.login(email, password));
}
}
