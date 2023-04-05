package com.isthifa.registration.security;

import com.isthifa.registration.dao.RegisterRepository;
import com.isthifa.registration.entity.RegisterD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private RegisterRepository registerRepository;
    @Override
    public UserDetails loadUserByUsername(String email)  {
        RegisterD registerD=registerRepository.findByEmail(email);
        if(registerD!=null)
        {
            return new CustomerConfig(registerD);
        }
        throw new UsernameNotFoundException("user not available");
    }
}
