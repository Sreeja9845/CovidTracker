package com.example.covid.spring.service;

import com.example.covid.spring.entity.Login;
import com.example.covid.spring.exception.LoginNotFoundException;

public interface ILoginService {

	Login getLoginById(int loginId);
    Login addlogin( Login login);
	Login updateLoginById(Login login, int loginId) throws LoginNotFoundException;
	Login deleteLoginById(int loginId);

}
