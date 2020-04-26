package kz.project.mynotebook.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.project.mynotebook.interfaces.Event;
import kz.project.mynotebook.enums.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "issue")
@ToString(of = {"id", "createDate", "name", "finishDatePlan", "description", "priority"})
@EqualsAndHashCode(of = {"id"})

public class Issue implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime finishDatePlan;

    private String description;

    private PriorityIssue priority;

    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getFinishDatePlan() {
        return finishDatePlan;
    }

    public void setFinishDatePlan(LocalDateTime finishDatePlan) {
        this.finishDatePlan = finishDatePlan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityIssue getPriority() {
        return priority;
    }

    public void setPriority(PriorityIssue priority) {
        this.priority = priority;
    }

}
