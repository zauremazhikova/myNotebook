package kz.project.mynotebook.entities;

import kz.project.mynotebook.interfaces.Event;
import kz.project.mynotebook.enums.PriorityIssue;
import kz.project.mynotebook.enums.StatusIssue;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data
public class Issue implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "finish_date_plan")
    private Date finish_date_plan;

    @Column(name = "creat_date")
    private Date creat_date;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private PriorityIssue priority;

    @Column(name = "statusIssue")
    private StatusIssue statusIssue;

}
