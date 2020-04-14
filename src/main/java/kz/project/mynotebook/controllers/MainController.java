package kz.project.mynotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(path = "/")
    public String index(Model model){
        return "main";
    }

    @GetMapping(path = "/aboutSystem")
    public String register(Model model){
        return "aboutSystem";
    }

}
