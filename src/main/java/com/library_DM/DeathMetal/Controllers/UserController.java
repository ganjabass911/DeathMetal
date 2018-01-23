package com.library_DM.DeathMetal.Controllers;

import com.library_DM.DeathMetal.Servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getRegistrationForm(){
        return new ModelAndView("reg");
    }

    @PostMapping("/reg")
    public String post(@RequestParam Map<String, String> params) {
        System.out.println(params.get("username"));
        System.out.println(params.get("password"));
        return userService.regAccess(params.get("username"), params.get("password"));
    }


}