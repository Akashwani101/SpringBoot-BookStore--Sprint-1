package com.online_store2.online_store2.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_store2.online_store2.Entities.UserLogin;
import com.online_store2.online_store2.Repositories.UserLoginRepository;
import com.online_store2.online_store2.Service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Override
	public String signup(UserLogin userLogin) {
		userLoginRepository.save(userLogin)	;
		return "Account has been created";
		}

	@Override
	public String login(String email, String password) {
		UserLogin userLogin=userLoginRepository.findbyemailid(email);
		
		if(userLogin!=null)
		{
			if(userLogin.getPassword().equals(password))
		return "you are welcome";
				
				return "Invalid password";
		}
		else
			return "kindly create account";
	}
	

}
