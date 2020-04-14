package kz.project.mynotebook.entities;

import kz.project.mynotebook.interfaces.Event;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "birthday")

public class Birthday implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person")
    private String person;

    @Column(name = "date")
    private Date date;

}
