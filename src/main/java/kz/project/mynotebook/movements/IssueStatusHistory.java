package kz.project.mynotebook.movements;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.project.mynotebook.enums.StatusIssue;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "issueStatusHistory")
@ToString(of = {"id", "createDate", "issueId", "statusIssue"})
@EqualsAndHashCode(of = {"id"})

public class IssueStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    private Long issueId;

    private StatusIssue statusIssue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssue(Long issueId) {
        this.issueId = issueId;
    }

    public StatusIssue getStatusIssue() {
        return statusIssue;
    }

    public void setStatusIssue(StatusIssue statusIssue) {
        this.statusIssue = statusIssue;
    }

}
