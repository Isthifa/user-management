package com.isthifa.registration.service;

import com.isthifa.registration.dao.LoginResponse;
import com.isthifa.registration.entity.RegisterD;
import com.isthifa.registration.entity.loginDTO;

import java.util.List;

public interface RegisterService {
    RegisterD save(RegisterD registerD);
    boolean checkemail(String email);
    List<RegisterD> findAll();
    LoginResponse logind(loginDTO loginDTO);

}
