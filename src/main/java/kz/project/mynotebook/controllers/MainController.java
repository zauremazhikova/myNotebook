package kz.project.mynotebook.controllers;

import kz.project.mynotebook.entities.Birthday;
import kz.project.mynotebook.repositories.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping(path = "/")
    public String toStart(){
        return "index";
    }

    @GetMapping(path = "/aboutSystem")
    public String register(){
        return "aboutSystem";
    }

}
