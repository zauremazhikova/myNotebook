package kz.project.mynotebook.repositories;

import kz.project.mynotebook.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findAllByIdIsNotNull();
    Issue findIssueById(Long id);

}
