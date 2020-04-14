package kz.project.mynotebook.repositories;

import kz.project.mynotebook.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository  extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByIdIsNotNull();
    Schedule findScheduleById(Long id);

}
