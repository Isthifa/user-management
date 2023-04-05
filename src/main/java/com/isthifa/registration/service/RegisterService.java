package com.isthifa.registration.service;

import com.isthifa.registration.entity.RegisterD;

import java.util.List;

public interface RegisterService {
    RegisterD save(RegisterD registerD);
    boolean checkemail(String email);

}
