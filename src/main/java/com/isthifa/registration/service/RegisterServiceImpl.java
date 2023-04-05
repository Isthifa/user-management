package com.isthifa.registration.service;

import com.isthifa.registration.dao.RegisterRepository;
import com.isthifa.registration.entity.RegisterD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegisterServiceImpl implements RegisterService{

    private RegisterRepository registerRepository;
    @Autowired
    private BCryptPasswordEncoder pEncoder;


    @Autowired
    public RegisterServiceImpl(RegisterRepository TheregisterRepository)
    {
        registerRepository=TheregisterRepository;
    }
    @Override
    public RegisterD save(RegisterD registerD) {
        registerD.setPassword(pEncoder.encode(registerD.getPassword()));
        registerD.setRole("ROLE_USER");
        return registerRepository.save(registerD);
    }

    @Override
    public boolean checkemail(String email) {
        return registerRepository.existsByEmail(email);
    }

}
