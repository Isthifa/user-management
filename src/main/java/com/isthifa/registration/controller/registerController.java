package com.isthifa.registration.controller;


import com.isthifa.registration.entity.RegisterD;
import com.isthifa.registration.service.RegisterService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/register")
    public String register()
    {
        return "register";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute RegisterD registerD) {
        boolean check = registerService.checkemail(registerD.getEmail());
        if(check==true)
        {
            System.out.println("registration faild");
        }
        return "redirect:/register";
    }
}
