package ua.kiev.kmrf.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.kmrf.scheduler.entity.group.Group;

@Repository
public interface GroupRepository  extends JpaRepository<Group, Long> {
}
