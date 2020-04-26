package kz.project.mynotebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/homePage")

public class HomePageController {

    @Autowired
    private BirthdayController birthdayController;

    @GetMapping(path = "/listAll")
    public ResponseEntity<List<Map<String, List<Map<String, String>>>>> homePage(){
        List<Map<String, List<Map<String, String>>>> returnJson = new ArrayList<>();

        List<Map<String, String>> birthdaysJson = birthdayController.getAllBirthdaysJson();

        returnJson.add(new HashMap<String, List<Map<String, String>>>() {{
            put("birthdaysJson", birthdaysJson);
        }});

        return new ResponseEntity<>(returnJson, HttpStatus.OK);
    }

}
