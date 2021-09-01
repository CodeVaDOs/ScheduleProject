package ua.kiev.kmrf.scheduler.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.kmrf.scheduler.entity.schedule.Audience;

public interface AudienceRepository extends JpaRepository<Audience, Long> {
}
