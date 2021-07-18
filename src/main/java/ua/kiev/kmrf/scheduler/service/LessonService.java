package ua.kiev.kmrf.scheduler.service;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.entity.Lesson;
import ua.kiev.kmrf.scheduler.repository.LessonRepository;

import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson createLesson(Lesson lesson) {

        return lessonRepository.save(lesson);
    }
}
