package ua.kiev.kmrf.scheduler.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.kmrf.scheduler.entity.schedule.Schedule;
import ua.kiev.kmrf.scheduler.repository.RepositoryInterface;

public interface ScheduleRepository extends RepositoryInterface<Schedule> {
}
