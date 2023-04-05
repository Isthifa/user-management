package com.isthifa.registration.controller;

import com.isthifa.registration.dao.RegisterRepository;
import com.isthifa.registration.entity.RegisterD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private RegisterRepository registerRepository;
    @ModelAttribute
    public void userDetails(Model m, Principal p)
    {
        String email=p.getName();
        RegisterD registerD=registerRepository.findByEmail(email);
        m.addAttribute("user",registerD);
    }
    @GetMapping("/")
    public String home()
    {
        return "user/userlog";
    }
}
