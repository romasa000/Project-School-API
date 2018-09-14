package org.projectschool.school.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
public class MainController implements Serializable {
    @RequestMapping("/")
    @ResponseBody
    public String index(){

        String response = "Bienvenido a Proyect School";
        return response;
    }
}
