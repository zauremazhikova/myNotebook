package kz.project.mynotebook.entities;

import kz.project.mynotebook.interfaces.Event;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "location")
    private String location;

}
