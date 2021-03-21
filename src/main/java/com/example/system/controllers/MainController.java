package com.example.system.controllers;

import com.example.system.controllers.services.TempService;
import com.example.system.data.WorkWithData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    TempService tempService;

    @GetMapping("/")
    public String home() {


        return "page";
    }

    @GetMapping("/day")
    public ResponseEntity<String> day(@RequestParam(value = "cityId") String city) {
        double[] answ = tempService.getAllTempsByDays(city);
        String answer = "";
        for (int i = 0; i < answ.length; i++) {
            answer += answ[i];
            if (i != answ.length - 1) {
                answer += "#";
            }
        }
        //System.out.println(answer);
        return new ResponseEntity<String>(answer, HttpStatus.OK);
    }


}