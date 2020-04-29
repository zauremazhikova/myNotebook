package kz.project.mynotebook.controllers;

import kz.project.mynotebook.entities.Issue;
import kz.project.mynotebook.repositories.IssueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/issue")

public class IssueController {

    @Autowired
    private IssueRepository issueRepository;

    @GetMapping
    public List<Issue> getAllIssues(){
        return issueRepository.findAllByIdIsNotNull();
    }

    @GetMapping(path = "{id}")
    public Issue getOneIssue(@PathVariable("id") Long id){
        return issueRepository.findIssueById(id);
    }

    @PostMapping
    public Issue create(@RequestBody Issue issue){
        issue.setCreateDate(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    @PutMapping("{id}")
    public Issue update(
            @PathVariable("id") Issue issueFromDBb,
            @RequestBody Issue issue){

        BeanUtils.copyProperties(issue, issueFromDBb, "id");
        return issueRepository.save(issueFromDBb);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Issue issues){
        issueRepository.delete(issues);
    }

    ///

    public List<Map<String, String>> getAllIssuesJson(){

        List<Issue> issues = issueRepository.findAllByIdIsNotNull();
        List<Map<String, String>> issuesJson = new ArrayList<>();

        if (issues.size()!=0) {
            for (Issue i : issues) {
                issuesJson.add(new HashMap<String, String>() {{
                    put("id", i.getId().toString());
                    put("name", i.getName());
                    put("createDate", i.getCreateDate().toString());
                    put("finishDatePlan", i.getFinishDatePlan().toString());
                    put("description", i.getDescription());
                    put("priority", i.getPriority().toString());
                }});
            }
        }
        return issuesJson;
    }
}
