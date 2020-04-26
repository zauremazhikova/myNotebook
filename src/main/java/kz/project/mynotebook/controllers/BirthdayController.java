package kz.project.mynotebook.controllers;

import kz.project.mynotebook.entities.Birthday;
import kz.project.mynotebook.repositories.BirthdayRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/birthday")

public class BirthdayController {

    @Autowired
    private BirthdayRepository birthdayRepository;

    @GetMapping
    public List<Birthday> getAllBirthdays(){
        return birthdayRepository.findAllByIdIsNotNull();
    }

    @GetMapping(path = "{id}")
    public Birthday getOneBirthday(@PathVariable("id") Long id){
        return birthdayRepository.findBirthdayById(id);
    }

    @PostMapping(path = "create/json")
    public Birthday create(@RequestBody Birthday birthday){
        return birthdayRepository.save(birthday);
    }

    @PutMapping("{id}")
    public Birthday update(
            @PathVariable("id") Birthday birthdayFromDBb,
            @RequestBody Birthday birthday){

        BeanUtils.copyProperties(birthday, birthdayFromDBb, "id");
        return birthdayRepository.save(birthday);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Birthday birthday){
        birthdayRepository.delete(birthday);
    }

    ///

    public List<Map<String, String>> getAllBirthdaysJson(){

        List<Birthday> birthdays = birthdayRepository.findAllByIdIsNotNull();
        List<Map<String, String>> birthdaysJson = new ArrayList<>();

        if (birthdays.size()!=0) {
            for (Birthday i : birthdays) {
                birthdaysJson.add(new HashMap<String, String>() {{
                    put("id", i.getId().toString());
                    put("person", i.getPerson());
                    put("date", i.getDate().toString());
                }});
            }
        }
        return birthdaysJson;
    }


}
