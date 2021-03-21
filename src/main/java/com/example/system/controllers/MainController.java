package com.example.system.controllers;

import com.example.system.controllers.services.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    TempService tempService;

    @GetMapping("/")
    public String home(Model model) {
        tempService.addTemp(0,null,1l);
        return "hello";
    }


}