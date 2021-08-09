package ua.kiev.kmrf.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.kmrf.scheduler.entity.lesson.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
