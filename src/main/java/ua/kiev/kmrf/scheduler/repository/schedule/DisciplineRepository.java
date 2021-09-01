package ua.kiev.kmrf.scheduler.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.kmrf.scheduler.entity.schedule.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
