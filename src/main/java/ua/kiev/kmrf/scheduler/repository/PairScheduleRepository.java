package ua.kiev.kmrf.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.kmrf.scheduler.entity.schedule.PairSchedule;

@Repository
public interface PairScheduleRepository extends JpaRepository<PairSchedule, Long> {
}