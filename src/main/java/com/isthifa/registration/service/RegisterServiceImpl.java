package com.isthifa.registration.service;

import com.isthifa.registration.dao.LoginResponse;
import com.isthifa.registration.dao.RegisterRepository;
import com.isthifa.registration.entity.RegisterD;
import com.isthifa.registration.entity.loginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterRepository registerRepository;
    @Autowired
    private BCryptPasswordEncoder pEncoder;


    @Autowired
    public RegisterServiceImpl(RegisterRepository TheregisterRepository) {
        registerRepository = TheregisterRepository;
    }

    @Override
    public RegisterD save(RegisterD registerD) {
        boolean t=registerRepository.existsByEmail(registerD.getEmail());
        if(t)
        {
            throw new RuntimeException("Already exists");
        }
        else {
            registerD.setPassword(pEncoder.encode(registerD.getPassword()));
            registerD.setRole("ROLE_USER");
            return registerRepository.save(registerD);
        }
    }

    @Override
    public boolean checkemail(String email) {
        return registerRepository.existsByEmail(email);
    }

    @Override
    public List<RegisterD> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public LoginResponse logind(loginDTO loginDTO) {
        String msg = "";
        RegisterD registerD = registerRepository.findByEmail(loginDTO.getEmail());
        if (registerD != null) {
            String password = loginDTO.getPassword();
            String encodedpassword = registerD.getPassword();
            boolean isPwdRight = pEncoder.matches(password, encodedpassword);
            if (isPwdRight) {
                Optional<RegisterD> registerD1 = registerRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedpassword);
                if (registerD1.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }

    }
}