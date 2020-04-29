package kz.project.mynotebook.controllers;

import kz.project.mynotebook.entities.Schedule;
import kz.project.mynotebook.repositories.ScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/schedule")

public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping
    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAllByIdIsNotNull();
    }

    @GetMapping(path = "{id}")
    public Schedule getOneSchedule(@PathVariable("id") Long id){
        return scheduleRepository.findScheduleById(id);
    }

    @PostMapping
    public Schedule create(@RequestBody Schedule schedule){
        schedule.setCreateDate(LocalDateTime.now());
        return scheduleRepository.save(schedule);
    }

    @PutMapping("{id}")
    public Schedule update(
            @PathVariable("id") Schedule scheduleFromDBb,
            @RequestBody Schedule schedule){

        BeanUtils.copyProperties(schedule, scheduleFromDBb, "id");
        return scheduleRepository.save(scheduleFromDBb);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Schedule schedule){
        scheduleRepository.delete(schedule);
    }

    ///

    public List<Map<String, String>> getAllSchedulesJson(){

        List<Schedule> schedules = scheduleRepository.findAllByIdIsNotNull();
        List<Map<String, String>> schedulesJson = new ArrayList<>();

        if (schedules.size()!=0) {
            for (Schedule i : schedules) {
                schedulesJson.add(new HashMap<String, String>() {{
                    put("id", i.getId().toString());
                    put("name", i.getName());
                    put("createDate", i.getCreateDate().toString());
                    put("date", i.getDate().toString());
                    put("location", i.getLocation());
                }});
            }
        }
        return schedulesJson;
    }

}
