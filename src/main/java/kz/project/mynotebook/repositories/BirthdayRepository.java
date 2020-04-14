package kz.project.mynotebook.repositories;

import kz.project.mynotebook.entities.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BirthdayRepository extends JpaRepository<Birthday, Long> {

    List<Birthday> findAllByIdIsNotNull();
    Birthday findBirthdayById(Long id);

}
