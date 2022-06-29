package com.example.covid.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid.spring.entity.Login;
import com.example.covid.spring.exception.LoginNotFoundException;
import com.example.covid.spring.repository.ILoginRepository;
@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	ILoginRepository loginRepo;

	@Override
	public Login getLoginById(int loginId) {

		Optional<Login> login = loginRepo.findById(loginId);
		if (login.isPresent()) {
			return login.get();
		} else {
			return null;
		}
	}

	@Override
	public Login addlogin(Login login) {

		return loginRepo.save(login);
	}

	@Override
	public Login updateLoginById(Login login, int loginId) throws LoginNotFoundException {

		Optional<Login> dbpat = loginRepo.findById(loginId);
		if (dbpat.isPresent()) {
			return loginRepo.save(login);
		} else {
			throw new LoginNotFoundException("Login Unsuccesfull");
		}
	}

	@Override
	public Login deleteLoginById(int loginId) {
		/*Optional <Login>login=loginRepo.findById(loginId);
		if(login.isPresent()) {
			loginRepo.deleteById(loginId);
		}else 
		{
			return login.get();
		}
		return null;
		}
		*/
		Optional<Login> login=loginRepo.findById(loginId);
		loginRepo.deleteById(loginId);
		return login.get();

}
}