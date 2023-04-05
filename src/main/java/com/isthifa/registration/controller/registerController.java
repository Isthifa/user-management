package com.isthifa.registration.controller;


import com.isthifa.registration.dao.LoginResponse;
import com.isthifa.registration.entity.RegisterD;
import com.isthifa.registration.entity.loginDTO;
import com.isthifa.registration.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api")
public class registerController {
    private RegisterService registerService;
    @Autowired
    public registerController(RegisterService registerl)
    {
        registerService=registerl;
    }

    @GetMapping("/")
    public String home()
    {
        return "index";
    }
    @GetMapping("/userlog")
    public String usr()
    {
        return "userlog";
    }
    @GetMapping("/userlogin")
    public String log()
    {
        return "userlogin";
    }
    @GetMapping("/userlogfail")
    public String logf()
    {
        return "userlogfail";
    }
    @PostMapping ("/lsave")
    public ResponseEntity<?> responseEntity(@ModelAttribute loginDTO loginDTO)
    {
        LoginResponse loginResponse = registerService.logind(loginDTO);
        boolean check = loginResponse.isStatus();

        if (check) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/api/userlog"));
            return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/api/userlogfail"));
            return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute RegisterD registerD) {
        boolean check = registerService.checkemail(registerD.getEmail());
        if(check) {
            return "redirect:/api/register";
        }
        else {
            registerService.save(registerD);
        }
        return "redirect:/api/register";
    }
}
