package com.isthifa.registration.dao;

import com.isthifa.registration.entity.RegisterD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterD,Integer> {
    boolean existsByEmail(String email);

    RegisterD findByEmail(String email);
}
