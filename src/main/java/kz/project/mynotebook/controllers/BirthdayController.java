package kz.project.mynotebook.controllers;
import kz.project.mynotebook.entities.Birthday;
import kz.project.mynotebook.repositories.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/birthday")

public class BirthdayController {

    @Autowired
    private BirthdayRepository birthdayRepository;

    @GetMapping(path = "/")
    public String toStart(){
        return "birthday";
    }

    @GetMapping (path = "/listOfBirthdays")
    public List<Map<String, String>> listAllBirthdays(){
        List<Birthday> birthdays = birthdayRepository.findAllByIdIsNotNull();
        List<Map<String, String>> birthdaysJson = new ArrayList<>();

        for (Birthday i : birthdays) {
            birthdaysJson.add(new HashMap<String, String>() {{
                put("id", i.getId().toString());
                put("person", i.getPerson());
                put("date", i.getDate().toString());
            }});
        }

        return birthdaysJson;
    }

    @GetMapping(path = "{id}")
    public List<Map<String, String>> getOneBirthday(@PathVariable Long id){
        Birthday birthday = birthdayRepository.findBirthdayById(id);
        List<Map<String, String>> birthdayJson = new ArrayList<>();
        birthdayJson.add(new HashMap<String, String>() {{
            put("id", birthday.getId().toString());
            put("person", birthday.getPerson());
            put("date", birthday.getDate().toString());
        }});
        return birthdayJson;
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> birthday){

        return birthday;

    }

}
